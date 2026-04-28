package dgtic.core.service;

import dgtic.core.model.dto.InscripcionAdminDTO;
import dgtic.core.model.dto.InscripcionesDTO;
import dgtic.core.model.entity.Inscripciones;
import java.util.List;

public interface InscripcionService {
    void actualizarCalificacion(InscripcionesDTO inscripcionDTO);
    List<Inscripciones> obtenerTodasLasInscripciones();
    List<Inscripciones> obtenerInscripcionesPorAlumno(Integer usuarioId);
    List<Inscripciones> obtenerInscripcionesPorProfesor(Integer usuarioId);
    void inscribirAlumnoAdmin(InscripcionAdminDTO dto);
}