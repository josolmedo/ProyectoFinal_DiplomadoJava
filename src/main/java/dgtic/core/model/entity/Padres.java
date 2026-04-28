package dgtic.core.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Padres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Padres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true, nullable = false)
    private Usuarios usuario;

    // Un Padre tiene varios Alumnos (Hijos)
    @OneToMany(mappedBy = "padre")
    @JsonIgnore
    private List<Alumnos> hijos;

    @Override
    public String toString() {
        return "Padres{id=" + id + ", usuario=" + (usuario != null ? usuario.getNombre() : "null") + "}";
    }
}