package dgtic.core.controller;

import dgtic.core.model.dto.AsistenciasDTO;
import dgtic.core.model.entity.Asistencias;
import dgtic.core.model.entity.Inscripciones;
import dgtic.core.model.entity.Usuarios;
import dgtic.core.service.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumnos")
public class AlumnosController {

    @Autowired
    private AsistenciaService asistenciaService;

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ReportePdfService reportePdfService;

    @Autowired
    private CorreoService correoService;

    @GetMapping("/lista-asignaturas")
    public String listarAsignaturas(HttpSession session, Model model) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return "redirect:/login"; // Protección

        // Solo traemos las materias a las que ESTE alumno está inscrito
        List<Inscripciones> misMaterias = inscripcionService.obtenerInscripcionesPorAlumno(usuarioId);

        model.addAttribute("contenido", "Mi Carga Académica");
        model.addAttribute("inscripciones", misMaterias);

        return "alumnos/lista-asignaturas";
    }

    @GetMapping("/registrar-asistencia")
    public String mostrarFormularioAsistencia(HttpSession session, Model model) {

        //Seguridad y validación
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return "redirect:/login";

        model.addAttribute("asistenciaDTO", new AsistenciasDTO());

        // El dropdown ahora solo mostrará los grupos donde él está inscrito
        model.addAttribute("misInscripciones", inscripcionService.obtenerInscripcionesPorAlumno(usuarioId));
        return "alumnos/registrar-asistencia";
    }

    @PostMapping("/registrar-asistencia")
    public String procesarAsistencia(@Valid @ModelAttribute("asistenciaDTO") AsistenciasDTO asistenciaDTO,
                                     BindingResult result,
                                     HttpSession session,
                                     Model model) {

        Integer usuarioId = (Integer) session.getAttribute("usuarioId");

        if (result.hasErrors()) {
            model.addAttribute("misInscripciones", inscripcionService.obtenerInscripcionesPorAlumno(usuarioId));
            return "alumnos/registrar-asistencia";
        }

        try {
            // Obtenemos al usuario para sacar su ID de Alumno real de forma segura (Backend)
            // Esto evita que el alumno mande el ID de un compañero modificado en el HTML
            Usuarios usuarioLogueado = usuarioService.buscarPorId(usuarioId);
            asistenciaDTO.setIdAlumno(usuarioLogueado.getAlumno().getId());

            asistenciaService.guardarAsistencia(asistenciaDTO);

        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("misInscripciones", inscripcionService.obtenerInscripcionesPorAlumno(usuarioId));
            return "alumnos/registrar-asistencia";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error general al guardar.");
            model.addAttribute("misInscripciones", inscripcionService.obtenerInscripcionesPorAlumno(usuarioId));
            return "alumnos/registrar-asistencia";
        }

        return "redirect:/alumnos/registrar-asistencia?exito";
    }

    // Descargar PDF
    @GetMapping("/descargar-calificaciones")
    public ResponseEntity<byte[]> descargarCalificacionesPdf(HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return ResponseEntity.status(401).build();

        Usuarios usuario = usuarioService.buscarPorId(usuarioId);
        List<Inscripciones> misMaterias = inscripcionService.obtenerInscripcionesPorAlumno(usuarioId);

        byte[] pdf = reportePdfService.generarReporteCalificaciones(misMaterias, usuario);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Mis_Calificaciones.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

    // Enviar email
    @GetMapping("/enviar-calificaciones")
    public String enviarCalificacionesCorreo(HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return "redirect:/login";

        try {
            Usuarios usuario = usuarioService.buscarPorId(usuarioId);
            List<Inscripciones> misMaterias = inscripcionService.obtenerInscripcionesPorAlumno(usuarioId);

            // Generamos el PDF en memoria
            byte[] pdf = reportePdfService.generarReporteCalificaciones(misMaterias, usuario);

            // Armamos el correo usando el email real del alumno
            String cuerpo = "Hola " + usuario.getNombre() + ",\n\nAdjunto encontrarás tu reporte de calificaciones actualizado.";
            correoService.enviarCorreoConPdf(usuario.getEmail(), "Tu Reporte de Calificaciones - EscuRed", cuerpo, pdf, "Calificaciones.pdf");

            return "redirect:/alumnos/lista-asignaturas?correoExito";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/alumnos/lista-asignaturas?correoError";
        }
    }

    // Descargar asistencias
    @GetMapping("/descargar-asistencias")
    public ResponseEntity<byte[]> descargarAsistenciasPdf(HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return ResponseEntity.status(401).build();

        Usuarios usuario = usuarioService.buscarPorId(usuarioId);
        List<Asistencias> misAsistencias = asistenciaService.obtenerAsistenciasPorAlumno(usuarioId);

        byte[] pdf = reportePdfService.generarReporteAsistencias(misAsistencias, usuario);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Mis_Asistencias.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

    // Enviar asistencias por correo
    @GetMapping("/enviar-asistencias")
    public String enviarAsistenciasCorreo(HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return "redirect:/login";

        try {
            Usuarios usuario = usuarioService.buscarPorId(usuarioId);
            List<Asistencias> misAsistencias = asistenciaService.obtenerAsistenciasPorAlumno(usuarioId);

            byte[] pdf = reportePdfService.generarReporteAsistencias(misAsistencias, usuario);

            String cuerpo = "Hola " + usuario.getNombre() + ",\n\nAdjunto encontrarás tu historial de asistencias registradas en EscuRed.";
            correoService.enviarCorreoConPdf(usuario.getEmail(), "Tu Reporte de Asistencias - EscuRed", cuerpo, pdf, "Historial_Asistencias.pdf");

            return "redirect:/alumnos/registrar-asistencia?correoExito";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/alumnos/registrar-asistencia?correoError";
        }
    }

}