package dgtic.core.repository;

import dgtic.core.model.entity.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesores, Integer> {
}