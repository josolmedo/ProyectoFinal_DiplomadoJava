package dgtic.core.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AsistenciasDTO {
    private Integer id;

    // Se recibe como String desde el formulario HTML (type="date") para aplicar conversión a LocalDate en el controlador
    @NotBlank(message = "La fecha es obligatoria")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "El formato de fecha debe ser YYYY-MM-DD")
    private String fecha;


    // El controlador de cada uno se encarga de rellenar lo que falte.
    private Integer idAlumno;
    private Integer idGrupo;
    private Integer idInscripcion;
}