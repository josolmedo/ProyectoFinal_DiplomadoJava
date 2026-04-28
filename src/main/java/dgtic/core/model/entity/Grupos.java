package dgtic.core.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Grupos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Grupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignaturas asignatura;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesores profesor;

    // Para borrar:

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Inscripciones> inscripciones;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Asistencias> asistencias;



    /*

    @OneToMany(mappedBy = "grupo")
    private List<Inscripciones> inscripciones;

    @OneToMany(mappedBy = "grupo")
    private List<Asistencias> asistencias;
    */
    @Override
    public String toString() {
        return "Grupos{id=" + id + ", nombre='" + nombre + "'}";
    }
}