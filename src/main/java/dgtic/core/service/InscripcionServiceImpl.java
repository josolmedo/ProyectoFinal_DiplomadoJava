package dgtic.core.service;

import dgtic.core.model.dto.InscripcionAdminDTO;
import dgtic.core.model.dto.InscripcionesDTO;
import dgtic.core.model.entity.Inscripciones;
import dgtic.core.repository.AlumnoRepository;
import dgtic.core.repository.GrupoRepository;
import dgtic.core.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public void actualizarCalificacion(InscripcionesDTO dto) {
        // Lógica de negocio para actualizar solo la calificación
        Inscripciones inscripcion = inscripcionRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("El registro de inscripción no existe"));

        inscripcion.setCalificacion(dto.getCalificacion());
        inscripcionRepository.save(inscripcion);
    }

    @Override
    public List<Inscripciones> obtenerTodasLasInscripciones() {
        return inscripcionRepository.findAll();
    }

    @Override
    public List<Inscripciones> obtenerInscripcionesPorAlumno(Integer usuarioId) {
        return inscripcionRepository.findByAlumnoUsuarioId(usuarioId);
    }

    @Override
    public List<Inscripciones> obtenerInscripcionesPorProfesor(Integer usuarioId) {
        return inscripcionRepository.findByGrupoProfesorUsuarioId(usuarioId);
    }

    @Override
    public void inscribirAlumnoAdmin(InscripcionAdminDTO dto) {
        // 1. Validamos que el alumno no esté inscrito ya en ese mismo grupo
        if (inscripcionRepository.existsByAlumnoIdAndGrupoId(dto.getIdAlumno(), dto.getIdGrupo())) {
            throw new IllegalStateException("El alumno ya se encuentra inscrito en este grupo.");
        }

        Inscripciones nuevaInscripcion = new Inscripciones();

        nuevaInscripcion.setAlumno(alumnoRepository.findById(dto.getIdAlumno())
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado")));

        nuevaInscripcion.setGrupo(grupoRepository.findById(dto.getIdGrupo())
                .orElseThrow(() -> new IllegalArgumentException("Grupo no encontrado")));

        // La calificación inicia nula por defecto
        nuevaInscripcion.setCalificacion(null);

        inscripcionRepository.save(nuevaInscripcion);
    }
}
