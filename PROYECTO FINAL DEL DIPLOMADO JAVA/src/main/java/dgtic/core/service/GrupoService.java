package dgtic.core.service;
import dgtic.core.model.dto.GruposDTO;
import dgtic.core.model.entity.Grupos;
import java.util.List;

public interface GrupoService {
    List<Grupos> obtenerTodos();
    void guardarGrupo(GruposDTO dto);
    GruposDTO obtenerPorId(Integer id);
    void eliminar(Integer id);
}