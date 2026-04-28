package dgtic.core.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Asignaturas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asignaturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150, unique = true)
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "asignatura")
    private List<Grupos> grupos;

    @Override
    public String toString() {
        return "Asignaturas{id=" + id + ", nombre='" + nombre + "'}";
    }
}