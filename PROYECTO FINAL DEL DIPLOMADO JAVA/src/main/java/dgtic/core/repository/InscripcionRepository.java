package dgtic.core.repository;

import dgtic.core.model.entity.Inscripciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripciones, Integer> {

    // Comparaciones: Busca inscripciones con calificación mayor a un valor (ej. alumnos aprobados)
    List<Inscripciones> findByCalificacionGreaterThan(BigDecimal calificacion);

    // Obtiene las 3 mejores calificaciones registradas de mayor a menor
    List<Inscripciones> findTop3ByOrderByCalificacionDesc();

    // Cuenta cuántos alumnos están inscritos en un grupo específico
    long countByGrupoId(Integer grupoId);


    // Calcular el promedio general de un alumno específico
    @Query("SELECT AVG(i.calificacion) FROM Inscripciones i WHERE i.alumno.id = :alumnoId")
    Double obtenerPromedioPorAlumno(@Param("alumnoId") Integer alumnoId);


    // SQL Nativo: Obtener todas las inscripciones con calificación aprobatoria (mayor o igual a 6.0)
    @Query(value = "SELECT * FROM Inscripciones WHERE calificacion >= 6.0", nativeQuery = true)
    List<Inscripciones> findInscripcionesAprobadasNativo();

    List<Inscripciones> findByAlumnoUsuarioId(Integer usuarioId);

    List<Inscripciones> findByGrupoProfesorUsuarioId(Integer usuarioId);

    // Verifica si un alumno ya está inscrito en ese grupo específico
    boolean existsByAlumnoIdAndGrupoId(Integer idAlumno, Integer idGrupo);

}