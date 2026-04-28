package dgtic.core.repository;


import dgtic.core.model.entity.Asignaturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AsignaturaRepository extends JpaRepository<Asignaturas, Integer> {

    // Obtiene la primera asignatura cuyo nombre empiece con un prefijo (ej. "Mat")
    Optional<Asignaturas> findFirstByNombreStartingWith(String prefijo);

    boolean existsByNombre(String nombre);

    // SQL Nativo: Contar cuántos grupos están abiertos para una asignatura en específico
    @Query(value = "SELECT COUNT(*) FROM Grupos WHERE id_asignatura = :asignaturaId", nativeQuery = true)
    long contarGruposPorAsignaturaNativo(@Param("asignaturaId") Integer asignaturaId);

}