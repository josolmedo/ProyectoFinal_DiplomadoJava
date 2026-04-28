package dgtic.core.repository;

import dgtic.core.model.entity.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumnos, Integer> {
}