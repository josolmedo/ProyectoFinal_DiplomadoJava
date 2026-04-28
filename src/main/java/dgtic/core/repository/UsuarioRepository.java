package dgtic.core.repository;

import dgtic.core.model.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {

    // 1. Like / Containing: Busca usuarios cuyo nombre contenga una cadena (ignorando mayúsculas)
    List<Usuarios> findByNombreContainingIgnoreCase(String nombre);

    // 2. Combinaciones OR: Busca usuarios que coincidan con un nombre o un apellido
    List<Usuarios> findByNombreOrApellido(String nombre, String apellido);

    // 3. Exists: Verifica si ya existe un usuario registrado con un email específico
    boolean existsByEmail(String email);


    // 1. JPQL: Obtener todos los usuarios que pertenecen a un rol específico por el nombre del rol
    @Query("SELECT u FROM Usuarios u WHERE u.rol.nombre = :nombreRol")
    List<Usuarios> findUsuariosByNombreRol(@Param("nombreRol") String nombreRol);

    // SELECT * FROM Usuarios WHERE email = ? AND password = ?
    Optional<Usuarios> findByEmailAndPassword(String email, String password);

    Optional<Usuarios> findByEmail(String email);


}