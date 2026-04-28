package dgtic.core.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PadresDTO {
    private Integer id;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Integer idUsuario;
}