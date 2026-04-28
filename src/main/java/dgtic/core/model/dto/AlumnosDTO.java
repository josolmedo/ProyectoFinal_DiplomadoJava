package dgtic.core.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AlumnosDTO {
    private Integer id;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Integer idUsuario;

    // Puede ser nulo si no se registra al padre inmediatamente
    private Integer idPadre;
}