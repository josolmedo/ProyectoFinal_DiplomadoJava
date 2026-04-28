package dgtic.core.controller.rest;

import dgtic.core.model.entity.Inscripciones;
import dgtic.core.repository.InscripcionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscripciones")
public class InscripcionRestController {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @GetMapping
    public List<Inscripciones> obtenerTodas() {
        return inscripcionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripciones> obtenerPorId(@PathVariable Integer id) {
        return inscripcionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inscripciones> crear(@Valid @RequestBody Inscripciones inscripcion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionRepository.save(inscripcion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripciones> actualizar(@PathVariable Integer id, @RequestBody Inscripciones inscripcion) {
        if (!inscripcionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        inscripcion.setId(id);
        return ResponseEntity.ok(inscripcionRepository.save(inscripcion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (inscripcionRepository.existsById(id)) {
            inscripcionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}