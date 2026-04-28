package dgtic.core.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RolesDTO {
    private Integer id;

    @NotBlank(message = "El nombre del rol es obligatorio")
    private String nombre;
}