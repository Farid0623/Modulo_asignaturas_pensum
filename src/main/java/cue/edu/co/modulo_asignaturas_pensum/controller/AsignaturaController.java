package cue.edu.co.modulo_asignaturas_pensum.controller;

import cue.edu.co.modulo_asignaturas_pensum.dto.AsignaturaDTO;
import cue.edu.co.modulo_asignaturas_pensum.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @PostMapping
    public ResponseEntity<AsignaturaDTO> create(@RequestBody AsignaturaDTO asignaturaDTO) {
        return ResponseEntity.ok(asignaturaService.createAsignatura(asignaturaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> getById(@PathVariable String id) {
        AsignaturaDTO dto = asignaturaService.getAsignaturaById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaDTO>> getAll() {
        return ResponseEntity.ok(asignaturaService.getAllAsignaturas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> update(@PathVariable String id, @RequestBody AsignaturaDTO asignaturaDTO) {
        AsignaturaDTO dto = asignaturaService.updateAsignatura(id, asignaturaDTO);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        asignaturaService.deleteAsignatura(id);
        return ResponseEntity.noContent().build();
    }
}