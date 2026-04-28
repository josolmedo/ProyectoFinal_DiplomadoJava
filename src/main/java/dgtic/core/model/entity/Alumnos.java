package dgtic.core.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Alumnos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alumnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", unique = true, nullable = false)
    private Usuarios usuario;

    //Muchos alumnos pueden tener un padre
    @ManyToOne
    @JoinColumn(name = "id_padre")
    private Padres padre;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Inscripciones> inscripciones;

    @OneToMany(mappedBy = "alumno")
    @JsonIgnore
    private List<Asistencias> asistencias;

    @Override
    public String toString() {
        return "Alumnos{id=" + id + ", usuario=" + (usuario != null ? usuario.getNombre() : "null") + "}";
    }
}