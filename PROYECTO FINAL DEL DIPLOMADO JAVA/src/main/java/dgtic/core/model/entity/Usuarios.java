package dgtic.core.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String apellido;

    @Column(nullable = false, unique = true, length = 150)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    // Relación N:1 con Roles
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Roles rol;

    // --- Relaciones Inversas 1:1 ---

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Alumnos alumno;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profesores profesor;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Padres padre;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Administradores administrador;

    @Override
    public String toString() {
        return "Usuarios{id=" + id + ", nombre='" + nombre + "', email='" + email + "'}";
    }
}