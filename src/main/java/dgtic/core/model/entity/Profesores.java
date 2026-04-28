package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "Profesores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profesores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true, nullable = false)
    private Usuarios usuario;

    // Un Profesor imparte varios Grupos
    @JsonIgnore
    @OneToMany(mappedBy = "profesor")
    private List<Grupos> grupos;

    @Override
    public String toString() {
        return "Profesores{id=" + id + "}";
    }
}