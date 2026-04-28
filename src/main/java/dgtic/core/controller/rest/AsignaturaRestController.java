package dgtic.core.controller.rest;

import dgtic.core.model.dto.AsignaturasDTO;
import dgtic.core.model.entity.Asignaturas;
import dgtic.core.service.AsignaturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/asignaturas")
public class AsignaturaRestController {

    @Autowired
    private AsignaturaService asignaturaService;

    // LEER TODAS (GET)
    @GetMapping
    public ResponseEntity<List<Asignaturas>> obtenerTodas() {
        return ResponseEntity.ok(asignaturaService.obtenerTodas());
    }

    // LEER POR ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<AsignaturasDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(asignaturaService.obtenerPorId(id));
    }

    // CREAR (POST) @Valid para que entre al GlobalExceptionHandler
    @PostMapping
    public ResponseEntity<String> crearAsignatura(@Valid @RequestBody AsignaturasDTO dto) {
        asignaturaService.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Asignatura creada correctamente");
    }

    // ACTUALIZAR (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAsignatura(@PathVariable Integer id, @Valid @RequestBody AsignaturasDTO dto) {
        dto.setId(id);
        asignaturaService.guardar(dto); // Tu servicio actual maneja creación y actualización
        return ResponseEntity.ok("Asignatura actualizada correctamente");
    }

    // ELIMINAR (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAsignatura(@PathVariable Integer id) {
        asignaturaService.eliminar(id);
        return ResponseEntity.ok("Asignatura eliminada correctamente");
    }
}