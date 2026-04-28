package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Administradores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Administradores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true, nullable = false)
    private Usuarios usuario;

    @Override
    public String toString() {
        return "Administradores{id=" + id + ", usuario=" + (usuario != null ? usuario.getId() : "null") + "}";
    }
}