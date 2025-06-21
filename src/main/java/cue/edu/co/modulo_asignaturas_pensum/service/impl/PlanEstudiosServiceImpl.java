package cue.edu.co.modulo_asignaturas_pensum.service.impl;

import cue.edu.co.modulo_asignaturas_pensum.dto.PlanEstudiosDTO;
import cue.edu.co.modulo_asignaturas_pensum.model.PlanEstudios;
import cue.edu.co.modulo_asignaturas_pensum.repository.PlanEstudiosRepository;
import cue.edu.co.modulo_asignaturas_pensum.service.PlanEstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanEstudiosServiceImpl implements PlanEstudiosService {

    @Autowired
    private PlanEstudiosRepository planEstudiosRepository;

    private PlanEstudiosDTO mapToDTO(PlanEstudios plan) {
        PlanEstudiosDTO dto = new PlanEstudiosDTO();
        dto.setId(plan.getId());
        dto.setNombre(plan.getNombre());
        dto.setCodigo(plan.getCodigo());
        dto.setDuracionSemestres(plan.getDuracionSemestres());
        dto.setDescripcion(plan.getDescripcion());
        dto.setFacultad(plan.getFacultad());
        dto.setPrograma(plan.getPrograma());
        dto.setActivo(plan.getActivo());
        dto.setSemestres(plan.getSemestres());
        return dto;
    }

    private PlanEstudios mapToEntity(PlanEstudiosDTO dto) {
        PlanEstudios plan = new PlanEstudios();
        plan.setId(dto.getId());
        plan.setNombre(dto.getNombre());
        plan.setCodigo(dto.getCodigo());
        plan.setDuracionSemestres(dto.getDuracionSemestres());
        plan.setDescripcion(dto.getDescripcion());
        plan.setFacultad(dto.getFacultad());
        plan.setPrograma(dto.getPrograma());
        plan.setActivo(dto.getActivo());
        plan.setSemestres(dto.getSemestres());
        return plan;
    }

    @Override
    public PlanEstudiosDTO createPlanEstudios(PlanEstudiosDTO planEstudiosDTO) {
        PlanEstudios plan = mapToEntity(planEstudiosDTO);
        PlanEstudios saved = planEstudiosRepository.save(plan);
        return mapToDTO(saved);
    }

    @Override
    public PlanEstudiosDTO getPlanEstudiosById(String id) {
        Optional<PlanEstudios> opt = planEstudiosRepository.findById(id);
        return opt.map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<PlanEstudiosDTO> getAllPlanesEstudios() {
        return planEstudiosRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanEstudiosDTO updatePlanEstudios(String id, PlanEstudiosDTO planEstudiosDTO) {
        Optional<PlanEstudios> opt = planEstudiosRepository.findById(id);
        if (opt.isPresent()) {
            PlanEstudios plan = mapToEntity(planEstudiosDTO);
            plan.setId(id);
            PlanEstudios updated = planEstudiosRepository.save(plan);
            return mapToDTO(updated);
        }
        return null;
    }

    @Override
    public void deletePlanEstudios(String id) {
        planEstudiosRepository.deleteById(id);
    }
}