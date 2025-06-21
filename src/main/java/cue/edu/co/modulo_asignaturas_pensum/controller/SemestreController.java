package cue.edu.co.modulo_asignaturas_pensum.controller;


import cue.edu.co.modulo_asignaturas_pensum.dto.SemestreDTO;
import cue.edu.co.modulo_asignaturas_pensum.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/semestres")
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    @PostMapping
    public ResponseEntity<SemestreDTO> create(@RequestBody SemestreDTO semestreDTO) {
        return ResponseEntity.ok(semestreService.createSemestre(semestreDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemestreDTO> getById(@PathVariable String id) {
        SemestreDTO dto = semestreService.getSemestreById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<SemestreDTO>> getAll() {
        return ResponseEntity.ok(semestreService.getAllSemestres());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SemestreDTO> update(@PathVariable String id, @RequestBody SemestreDTO semestreDTO) {
        SemestreDTO dto = semestreService.updateSemestre(id, semestreDTO);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        semestreService.deleteSemestre(id);
        return ResponseEntity.noContent().build();
    }
}