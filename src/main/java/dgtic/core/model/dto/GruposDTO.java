package dgtic.core.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GruposDTO {
    private Integer id;

    @NotBlank(message = "El nombre del grupo es obligatorio")
    private String nombre;

    @NotNull(message = "Debe asignar una asignatura")
    private Integer idAsignatura;

    @NotNull(message = "Debe asignar un profesor")
    private Integer idProfesor;
}
