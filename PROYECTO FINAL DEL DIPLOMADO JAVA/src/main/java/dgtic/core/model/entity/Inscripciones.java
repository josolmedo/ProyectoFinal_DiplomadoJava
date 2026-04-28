package dgtic.core.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Inscripciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inscripciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // para mapear DECIMAL(5,2)
    @Column(nullable = true)
    private Double calificacion;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    @NotNull(message = "El alumno es obligatorio")
    private Alumnos alumno;

    @ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    @NotNull(message = "El grupo es obligatorio")
    private Grupos grupo;

    @Override
    public String toString() {
        return "Inscripciones{id=" + id + ", calificacion=" + calificacion + "}";
    }
}