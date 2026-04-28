package dgtic.core.service;

import dgtic.core.model.dto.AsistenciasDTO;
import dgtic.core.model.entity.Asistencias;
import dgtic.core.model.entity.Grupos;
import java.util.List;

public interface AsistenciaService {
    void guardarAsistencia(AsistenciasDTO asistenciaDTO);
    List<Grupos> obtenerTodosLosGrupos();
    List<Asistencias> obtenerAsistenciasPorAlumno(Integer usuarioId);
    List<Asistencias> obtenerAsistenciasPorAlumnoYGrupo(Integer idAlumno, Integer idGrupo);
}
