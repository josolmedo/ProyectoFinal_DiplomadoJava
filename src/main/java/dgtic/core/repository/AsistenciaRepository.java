package dgtic.core.repository;

import dgtic.core.model.entity.Asistencias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencias, Integer> {

    // Combinaciones AND: Busca asistencias de un alumno específico en un grupo específico
    List<Asistencias> findByAlumnoIdAndGrupoId(Integer alumnoId, Integer grupoId);

    // Comparaciones y Ordenamiento: Busca asistencias en un rango de fechas y las ordena de más antigua a más reciente
    List<Asistencias> findByFechaBetweenOrderByFechaAsc(LocalDate fechaInicio, LocalDate fechaFin);

    // Verifica si ya existe el registro
    boolean existsByFechaAndAlumnoIdAndGrupoId(LocalDate fecha, Integer alumnoId, Integer grupoId);

    // Obtiene todas las asistencias de un alumno usando su ID de Usuario
    List<Asistencias> findByAlumnoUsuarioIdOrderByFechaDesc(Integer usuarioId);
}