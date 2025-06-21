package cue.edu.co.modulo_asignaturas_pensum.service;

import cue.edu.co.modulo_asignaturas_pensum.dto.SemestreDTO;

import java.util.List;

public interface SemestreService {
    SemestreDTO createSemestre(SemestreDTO semestreDTO);
    SemestreDTO getSemestreById(String id);
    List<SemestreDTO> getAllSemestres();
    SemestreDTO updateSemestre(String id, SemestreDTO semestreDTO);
    void deleteSemestre(String id);
}