package dgtic.core.service;

import dgtic.core.model.dto.GruposDTO;
import dgtic.core.model.entity.Grupos;
import dgtic.core.repository.AsignaturaRepository;
import dgtic.core.repository.GrupoRepository;
import dgtic.core.repository.ProfesorRepository;
import dgtic.core.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired private GrupoRepository grupoRepository;
    @Autowired private AsignaturaRepository asignaturaRepository;
    @Autowired private ProfesorRepository profesorRepository;

    @Override
    public List<Grupos> obtenerTodos() {
        return grupoRepository.findAll();
    }

    @Override
    public void guardarGrupo(GruposDTO dto) {
        // 1. Validación anti-duplicados
        if (dto.getId() == null && grupoRepository.existsByNombre(dto.getNombre())) {
            throw new IllegalStateException("El grupo '" + dto.getNombre() + "' ya existe en el sistema.");
        }

        Grupos grupo = new Grupos();
        if (dto.getId() != null) {
            grupo.setId(dto.getId());
        }

        grupo.setNombre(dto.getNombre());

        // 2. Buscamos y asignamos la Asignatura
        grupo.setAsignatura(asignaturaRepository.findById(dto.getIdAsignatura())
                .orElseThrow(() -> new IllegalArgumentException("Asignatura no encontrada")));

        // 3. Buscamos y asignamos al Profesor
        grupo.setProfesor(profesorRepository.findById(dto.getIdProfesor())
                .orElseThrow(() -> new IllegalArgumentException("Profesor no encontrado")));

        grupoRepository.save(grupo);
    }

    @Override
    public GruposDTO obtenerPorId(Integer id) {
        dgtic.core.model.entity.Grupos grupo = grupoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Grupo no encontrado"));

        // Mapeamos la entidad real a un DTO para mandarlo al formulario
        GruposDTO dto = new GruposDTO();
        dto.setId(grupo.getId());
        dto.setNombre(grupo.getNombre());
        dto.setIdAsignatura(grupo.getAsignatura().getId());
        dto.setIdProfesor(grupo.getProfesor().getId());

        return dto;
    }

    @Override
    public void eliminar(Integer id) {
        if (!grupoRepository.existsById(id)) {
            throw new dgtic.core.exception.NotDataFoundException("El grupo con ID " + id + " no existe.");
        }
        grupoRepository.deleteById(id);
    }


}