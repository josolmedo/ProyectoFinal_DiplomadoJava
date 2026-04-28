package dgtic.core.service;

import dgtic.core.model.dto.AsignaturasDTO;
import dgtic.core.model.entity.Asignaturas;
import dgtic.core.model.entity.Asistencias;

import java.util.List;

public interface AsignaturaService {
    List<Asignaturas> obtenerTodas();
    void guardar(AsignaturasDTO dto);
    AsignaturasDTO obtenerPorId(Integer id);
    void eliminar(Integer id);

}
