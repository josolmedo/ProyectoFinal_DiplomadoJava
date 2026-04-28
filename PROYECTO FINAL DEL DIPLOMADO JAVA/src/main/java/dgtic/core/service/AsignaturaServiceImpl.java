package dgtic.core.service;

import dgtic.core.model.dto.AsignaturasDTO;
import dgtic.core.model.entity.Asignaturas;
import dgtic.core.model.entity.Asistencias;
import dgtic.core.repository.AsignaturaRepository;
import dgtic.core.repository.AsistenciaRepository;
import dgtic.core.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Override
    public List<Asignaturas> obtenerTodas() {
        // Usa el método por defecto de JpaRepository para traer todas las materias
        return asignaturaRepository.findAll();
    }

    @Override
    public void guardar(AsignaturasDTO dto) {
        // (Solo si es una asignatura nueva)
        if (dto.getId() == null && asignaturaRepository.existsByNombre(dto.getNombre())) {
            throw new IllegalStateException("La asignatura '" + dto.getNombre() + "' ya existe en el sistema.");
        }

        Asignaturas asignatura = new Asignaturas();
        if (dto.getId() != null) {
            asignatura.setId(dto.getId());
        }
        asignatura.setNombre(dto.getNombre());
        asignaturaRepository.save(asignatura);
    }

    @Override
    public AsignaturasDTO obtenerPorId(Integer id) {
        Asignaturas asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asignatura no encontrada"));
        AsignaturasDTO dto = new AsignaturasDTO();
        dto.setId(asignatura.getId());
        dto.setNombre(asignatura.getNombre());
        return dto;
    }

    @Override
    public void eliminar(Integer id) {
        asignaturaRepository.deleteById(id);
    }



}