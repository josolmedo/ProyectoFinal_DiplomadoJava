package dgtic.core.service;

import dgtic.core.model.entity.Profesores;
import dgtic.core.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesores> obtenerTodos() {
        return profesorRepository.findAll();
    }
}