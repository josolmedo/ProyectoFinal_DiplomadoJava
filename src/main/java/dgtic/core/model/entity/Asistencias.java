package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Asistencias", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fecha", "id_alumno", "id_grupo"})
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asistencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumnos alumno;

    @ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    private Grupos grupo;

    @Override
    public String toString() {
        return "Asistencias{id=" + id + ", fecha=" + fecha + "}";
    }
}