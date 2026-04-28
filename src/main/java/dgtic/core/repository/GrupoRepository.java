package dgtic.core.repository;

import dgtic.core.model.entity.Grupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupos, Integer>{

    // Lista todos los grupos de un profesor ordenados alfabéticamente por el nombre del grupo
    List<Grupos> findByProfesorIdOrderByNombreAsc(Integer profesorId);



    // Obtener los grupos asignados a un profesor buscando por el ID de su Usuario
    @Query("SELECT g FROM Grupos g JOIN g.profesor p WHERE p.usuario.id = :usuarioId")
    List<Grupos> findGruposByUsuarioProfesorId(@Param("usuarioId") Integer usuarioId);

    boolean existsByNombre(String nombre);

}
