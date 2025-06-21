package cue.edu.co.modulo_asignaturas_pensum.service;

import cue.edu.co.modulo_asignaturas_pensum.dto.AsignaturaDTO;
import java.util.List;

public interface AsignaturaService {
    AsignaturaDTO createAsignatura(AsignaturaDTO asignaturaDTO);
    AsignaturaDTO getAsignaturaById(String id);
    List<AsignaturaDTO> getAllAsignaturas();
    AsignaturaDTO updateAsignatura(String id, AsignaturaDTO asignaturaDTO);
    void deleteAsignatura(String id);
}
