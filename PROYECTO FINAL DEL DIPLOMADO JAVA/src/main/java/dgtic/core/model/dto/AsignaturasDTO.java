package dgtic.core.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AsignaturasDTO {
    private Integer id;

    @NotBlank(message = "El nombre de la asignatura es obligatorio")
    private String nombre;
}