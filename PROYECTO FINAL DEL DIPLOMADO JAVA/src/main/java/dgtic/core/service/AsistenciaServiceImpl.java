package dgtic.core.service;

import dgtic.core.model.dto.AsistenciasDTO;
import dgtic.core.model.entity.Alumnos;
import dgtic.core.model.entity.Asistencias;
import dgtic.core.model.entity.Grupos;
import dgtic.core.repository.AsistenciaRepository;
import dgtic.core.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public void guardarAsistencia(AsistenciasDTO asistenciaDTO) {

        // Lógica de conversión
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaConvertida = LocalDate.parse(asistenciaDTO.getFecha(), formatter);

        if (asistenciaRepository.existsByFechaAndAlumnoIdAndGrupoId(
                fechaConvertida, asistenciaDTO.getIdAlumno(), asistenciaDTO.getIdGrupo())) {
            // Si ya existe, abortamos y mandamos este mensaje al controlador
            throw new IllegalStateException("Ya registraste tu asistencia para esta materia el día de hoy.");
        }

        Asistencias asistencia = new Asistencias();
        asistencia.setFecha(fechaConvertida);

        Grupos grupo = new Grupos();
        grupo.setId(asistenciaDTO.getIdGrupo());
        asistencia.setGrupo(grupo);

        Alumnos alumno = new Alumnos();
        alumno.setId(asistenciaDTO.getIdAlumno());
        asistencia.setAlumno(alumno);

        asistenciaRepository.save(asistencia);
    }

    @Override
    public List<Grupos> obtenerTodosLosGrupos() {
        return grupoRepository.findAll();
    }

    @Override
    public List<Asistencias> obtenerAsistenciasPorAlumno(Integer usuarioId) {
        return asistenciaRepository.findByAlumnoUsuarioIdOrderByFechaDesc(usuarioId);
    }

    @Override
    public List<Asistencias> obtenerAsistenciasPorAlumnoYGrupo(Integer idAlumno, Integer idGrupo) {
        return asistenciaRepository.findByAlumnoIdAndGrupoId(idAlumno, idGrupo);
    }

}