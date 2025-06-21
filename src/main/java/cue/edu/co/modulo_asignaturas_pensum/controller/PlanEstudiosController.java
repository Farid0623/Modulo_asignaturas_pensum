package cue.edu.co.modulo_asignaturas_pensum.controller;

import cue.edu.co.modulo_asignaturas_pensum.dto.PlanEstudiosDTO;
import cue.edu.co.modulo_asignaturas_pensum.service.PlanEstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes-estudios")
public class PlanEstudiosController {

    @Autowired
    private PlanEstudiosService planEstudiosService;

    @PostMapping
    public ResponseEntity<PlanEstudiosDTO> create(@RequestBody PlanEstudiosDTO planEstudiosDTO) {
        return ResponseEntity.ok(planEstudiosService.createPlanEstudios(planEstudiosDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanEstudiosDTO> getById(@PathVariable String id) {
        PlanEstudiosDTO dto = planEstudiosService.getPlanEstudiosById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PlanEstudiosDTO>> getAll() {
        return ResponseEntity.ok(planEstudiosService.getAllPlanesEstudios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanEstudiosDTO> update(@PathVariable String id, @RequestBody PlanEstudiosDTO planEstudiosDTO) {
        PlanEstudiosDTO dto = planEstudiosService.updatePlanEstudios(id, planEstudiosDTO);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        planEstudiosService.deletePlanEstudios(id);
        return ResponseEntity.noContent().build();
    }
}