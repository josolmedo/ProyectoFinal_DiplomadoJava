package dgtic.core.model.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InscripcionAdminDTO {
    @NotNull(message = "Debes seleccionar un alumno")
    private Integer idAlumno;
    @NotNull(message = "Debes seleccionar un grupo")
    private Integer idGrupo;
}