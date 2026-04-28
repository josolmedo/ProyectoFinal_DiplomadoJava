package dgtic.core.model.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InscripcionesDTO {
    private Integer id;

    @DecimalMin(value = "0.0", message = "La calificación mínima es 0")
    @DecimalMax(value = "10.0", message = "La calificación máxima es 10")
    private Double calificacion;


    private Integer idAlumno;
    private Integer idGrupo;
}