package dgtic.core.controller.rest;

import dgtic.core.model.dto.GruposDTO;
import dgtic.core.model.entity.Grupos;
import dgtic.core.service.GrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grupos")
public class GrupoRestController {

    @Autowired
    private GrupoService grupoService;

    // LEER TODOS (GET)
    @GetMapping
    public ResponseEntity<List<Grupos>> obtenerTodos() {
        return ResponseEntity.ok(grupoService.obtenerTodos());
    }

    // LEER POR ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<GruposDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(grupoService.obtenerPorId(id));
    }

    // CREAR (POST) - API PRINCIPAL: Maneja validaciones y relaciones
    @PostMapping
    public ResponseEntity<String> crearGrupo(@Valid @RequestBody GruposDTO dto) {
        // Al usar @Valid, si falta el idAsignatura o idProfesor,
        // nuestro GlobalExceptionHandler atrapará el error automáticamente.
        grupoService.guardarGrupo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Grupo creado correctamente con sus relaciones.");
    }

    // ACTUALIZAR (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarGrupo(@PathVariable Integer id, @Valid @RequestBody GruposDTO dto) {
        dto.setId(id);
        grupoService.guardarGrupo(dto);
        return ResponseEntity.ok("Grupo actualizado correctamente.");
    }

    // ELIMINAR (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarGrupo(@PathVariable Integer id) {
        grupoService.eliminar(id);
        return ResponseEntity.ok("Grupo eliminado correctamente.");
    }
}