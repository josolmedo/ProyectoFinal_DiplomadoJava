package dgtic.core.controller;

import dgtic.core.model.dto.AsignaturasDTO;
import dgtic.core.model.dto.GruposDTO;
import dgtic.core.model.dto.InscripcionAdminDTO;
import dgtic.core.model.dto.UsuariosDTO;
import dgtic.core.service.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AsignaturaService asignaturaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private GrupoService grupoService;
    @Autowired
    private InscripcionService inscripcionService;
    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private ReportePdfService reportePdfService;
    @Autowired
    private CorreoService correoService;

    // LECTURA
    @GetMapping("/asignaturas")
    public String listarAsignaturas(HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        model.addAttribute("contenido", "Gestión de Asignaturas");
        model.addAttribute("asignaturas", asignaturaService.obtenerTodas());
        return "administrador/lista-asignaturas-admin";
    }

    // CREACIÓN
    @GetMapping("/asignaturas/nueva")
    public String mostrarFormularioNueva(HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        model.addAttribute("contenido", "Nueva Asignatura");
        model.addAttribute("asignaturaDTO", new AsignaturasDTO());
        return "administrador/formulario-asignatura";
    }

    // ACTUALIZACIÓN
    @GetMapping("/asignaturas/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        model.addAttribute("contenido", "Editar Asignatura");
        model.addAttribute("asignaturaDTO", asignaturaService.obtenerPorId(id));
        return "administrador/formulario-asignatura";
    }

    // GUARDAR
    @PostMapping("/asignaturas/guardar")
    public String guardarAsignatura(@Valid @ModelAttribute("asignaturaDTO") AsignaturasDTO dto,
                                    BindingResult result, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        if (result.hasErrors()) {
            model.addAttribute("contenido", dto.getId() == null ? "Nueva Asignatura" : "Editar Asignatura");
            return "administrador/formulario-asignatura";
        }

        try {
            asignaturaService.guardar(dto);
            return "redirect:/administrador/asignaturas?exito";

        } catch (IllegalStateException e) {
            // Mostramos error de duplicado
            model.addAttribute("error", e.getMessage());
            model.addAttribute("contenido", dto.getId() == null ? "Nueva Asignatura" : "Editar Asignatura");
            return "administrador/formulario-asignatura";
        }
    }

    // ELIMINACIÓN
    @GetMapping("/asignaturas/eliminar/{id}")
    public String eliminarAsignatura(@PathVariable("id") Integer id, HttpSession session) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        try {
            asignaturaService.eliminar(id);
            return "redirect:/administrador/asignaturas?eliminado";
        } catch (Exception e) {
            // Falla si la asignatura ya tiene grupos asignados (Integridad referencial)
            return "redirect:/administrador/asignaturas?error";
        }
    }


    @PostMapping("/usuarios/guardar-alumno")
    public String guardarAlumnoAdmin(@Valid @ModelAttribute("usuarioDTO") UsuariosDTO dto,
                                     BindingResult result, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        if (result.hasErrors()) {
            return "administrador/formulario-alumno";
        }

        try {
            // El 3 es el ID de rol de Alumno
            usuarioService.registrarNuevoUsuario(dto, 3);
            return "redirect:/administrador/agregar-alumno?exito";

        } catch (IllegalStateException e) {
            // Aqui gestiono el duplicado
            model.addAttribute("error", e.getMessage()); // Mandará: "El correo ya está registrado..."
            return "administrador/formulario-alumno";
        }
    }


    @GetMapping("/agregar-alumno")
    public String mostrarFormularioAlumno(HttpSession session, Model model) {
        // Protección de ruta: Solo el ADMIN puede entrar
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        model.addAttribute("usuarioDTO", new UsuariosDTO());
        return "administrador/formulario-alumno";
    }

    @GetMapping("/agregar-profesor")
    public String mostrarFormularioProfesor(HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";
        model.addAttribute("usuarioDTO", new UsuariosDTO());
        // Puedes reusar el mismo HTML de alumno, solo cambia los títulos con Thymeleaf o haz una copia
        return "administrador/formulario-profesor";
    }

    @PostMapping("/usuarios/guardar-profesor")
    public String guardarProfesorAdmin(@Valid @ModelAttribute("usuarioDTO") UsuariosDTO dto, BindingResult result, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";
        if (result.hasErrors()) return "administrador/formulario-profesor";
        try {
            usuarioService.registrarNuevoUsuario(dto, 2); // 2 = ID de Rol Profesor
            return "redirect:/administrador/agregar-profesor?exito";
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            return "administrador/formulario-profesor";
        }
    }

    @GetMapping("/grupos/nuevo")
    public String nuevoGrupo(HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";
        model.addAttribute("grupoDTO", new GruposDTO());
        // Enviamos las listas para los <select> del HTML
        model.addAttribute("asignaturas", asignaturaService.obtenerTodas());
        model.addAttribute("profesores", profesorService.obtenerTodos());
        return "administrador/formulario-grupo";
    }

    @PostMapping("/grupos/guardar")
    public String guardarGrupo(@Valid @ModelAttribute("grupoDTO") GruposDTO dto, BindingResult result, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";
        if (result.hasErrors()) {
            model.addAttribute("asignaturas", asignaturaService.obtenerTodas());
            model.addAttribute("profesores", profesorService.obtenerTodos());
            return "administrador/formulario-grupo";
        }
        try {
            grupoService.guardarGrupo(dto); // Guardar el Grupo vinculado a la Asignatura y Profesor
            return "redirect:/administrador/grupos/nuevo?exito";
        } catch (Exception e) {
            model.addAttribute("error", "Error al crear el grupo: " + e.getMessage());
            model.addAttribute("asignaturas", asignaturaService.obtenerTodas());
            model.addAttribute("profesores", profesorService.obtenerTodos());
            return "administrador/formulario-grupo";
        }
    }

    @GetMapping("/grupos/editar/{id}")
    public String mostrarFormularioEditarGrupo(@PathVariable("id") Integer id, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        // Buscamos el grupo por ID y lo mandamos al formulario
        model.addAttribute("grupoDTO", grupoService.obtenerPorId(id));
        // Volvemos a mandar las listas para los selectores (comboboxes)
        model.addAttribute("asignaturas", asignaturaService.obtenerTodas());
        model.addAttribute("profesores", profesorService.obtenerTodos());

        return "administrador/formulario-grupo"; // Reutilizamos el mismo formulario de creación
    }

    @GetMapping("/grupos/eliminar/{id}")
    public String eliminarGrupo(@PathVariable("id") Integer id, HttpSession session) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        try {
            grupoService.eliminar(id);
            return "redirect:/administrador/grupos?eliminado=true";
        } catch (Exception e) {
            // Saltará al catch si intentas eliminar un grupo que ya tiene alumnos inscritos (Integridad Referencial)
            return "redirect:/administrador/grupos?error=true";
        }
    }

    @GetMapping("/inscribir")
    public String mostrarInscripcion(HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";
        model.addAttribute("inscripcionDTO", new InscripcionAdminDTO());
        model.addAttribute("alumnos", alumnoService.obtenerTodos());
        model.addAttribute("grupos", grupoService.obtenerTodos());
        return "administrador/formulario-inscripcion";
    }

    @PostMapping("/inscribir/guardar")
    public String guardarInscripcion(@Valid @ModelAttribute("inscripcionDTO") InscripcionAdminDTO dto, BindingResult result, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";
        if (result.hasErrors()) {
            model.addAttribute("alumnos", alumnoService.obtenerTodos());
            model.addAttribute("grupos", grupoService.obtenerTodos());
            return "administrador/formulario-inscripcion";
        }
        try {
            // Verificar si el alumno ya está en ese grupo para no duplicar
            inscripcionService.inscribirAlumnoAdmin(dto);
            return "redirect:/administrador/inscribir?exito";
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("alumnos", alumnoService.obtenerTodos());
            model.addAttribute("grupos", grupoService.obtenerTodos());
            return "administrador/formulario-inscripcion";
        }
    }

    @GetMapping("/grupos")
    public String listarGrupos(HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        model.addAttribute("contenido", "Gestión de Grupos");
        model.addAttribute("grupos", grupoService.obtenerTodos());
        return "administrador/lista-grupos-admin"; // Vista que ya tienes
    }

    @GetMapping("/grupos/reporte/descargar")
    public org.springframework.http.ResponseEntity<byte[]> descargarReporteGrupos(HttpSession session) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) {
            return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.UNAUTHORIZED).build();
        }

        // Obtener grupos y generar PDF
        java.util.List<dgtic.core.model.entity.Grupos> grupos = grupoService.obtenerTodos();
        byte[] pdfBytes = reportePdfService.generarReporteGrupos(grupos);

        // Iniciar la descarga en el navegador
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Reporte_Grupos_EscuRed.pdf");

        return new org.springframework.http.ResponseEntity<>(pdfBytes, headers, org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("/grupos/reporte/enviar")
    public String enviarReporteGruposPorCorreo(HttpSession session) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) {
            return "redirect:/login";
        }

        // 1. Obtener el ID del administrador desde la sesión
        Integer idAdmin = (Integer) session.getAttribute("usuarioId");
        dgtic.core.model.entity.Usuarios admin = usuarioService.buscarPorId(idAdmin);
        String destinatario = admin.getEmail();

        // 2. Generar el PDF
        java.util.List<dgtic.core.model.entity.Grupos> grupos = grupoService.obtenerTodos();
        byte[] pdfBytes = reportePdfService.generarReporteGrupos(grupos);

        // 3. Enviar el correo
        String asunto = "Reporte Automatizado de Grupos - EscuRed";
        String cuerpo = "Hola " + admin.getNombre() + ",\n\nSe adjunta el reporte actual de los grupos registrados en el sistema EscuRed solicitado desde tu cuenta.\n\nSaludos.";

        correoService.enviarCorreoConPdf(destinatario, asunto, cuerpo, pdfBytes, "Reporte_Grupos_EscuRed.pdf");

        // 4. Redirigir a la misma vista de grupos indicando que el correo se envió con éxito
        return "redirect:/administrador/grupos?correoEnviado=true";
    }









}