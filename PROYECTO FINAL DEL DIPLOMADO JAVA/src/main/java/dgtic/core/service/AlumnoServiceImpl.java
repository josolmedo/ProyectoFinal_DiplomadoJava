package dgtic.core.service;

import dgtic.core.model.entity.Alumnos;
import dgtic.core.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumnos> obtenerTodos() {
        return alumnoRepository.findAll();
    }
}
