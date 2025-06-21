package cue.edu.co.modulo_asignaturas_pensum.service;

import cue.edu.co.modulo_asignaturas_pensum.dto.PlanEstudiosDTO;

import java.util.List;

public interface PlanEstudiosService {
    PlanEstudiosDTO createPlanEstudios(PlanEstudiosDTO planEstudiosDTO);
    PlanEstudiosDTO getPlanEstudiosById(String id);
    List<PlanEstudiosDTO> getAllPlanesEstudios();
    PlanEstudiosDTO updatePlanEstudios(String id, PlanEstudiosDTO planEstudiosDTO);
    void deletePlanEstudios(String id);
}