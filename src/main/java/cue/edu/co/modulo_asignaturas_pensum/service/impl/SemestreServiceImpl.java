package cue.edu.co.modulo_asignaturas_pensum.service.impl;

import cue.edu.co.modulo_asignaturas_pensum.dto.SemestreDTO;
import cue.edu.co.modulo_asignaturas_pensum.model.Semestre;
import cue.edu.co.modulo_asignaturas_pensum.repository.SemestreRepository;
import cue.edu.co.modulo_asignaturas_pensum.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SemestreServiceImpl implements SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    private SemestreDTO mapToDTO(Semestre semestre) {
        SemestreDTO dto = new SemestreDTO();
        dto.setId(semestre.getId());
        dto.setNumero(semestre.getNumero());
        dto.setNombre(semestre.getNombre());
        dto.setDescripcion(semestre.getDescripcion());
        dto.setAsignaturas(semestre.getAsignaturas());
        dto.setPlanEstudiosId(semestre.getPlanEstudiosId());
        return dto;
    }

    private Semestre mapToEntity(SemestreDTO dto) {
        Semestre semestre = new Semestre();
        semestre.setId(dto.getId());
        semestre.setNumero(dto.getNumero());
        semestre.setNombre(dto.getNombre());
        semestre.setDescripcion(dto.getDescripcion());
        semestre.setAsignaturas(dto.getAsignaturas());
        semestre.setPlanEstudiosId(dto.getPlanEstudiosId());
        return semestre;
    }

    @Override
    public SemestreDTO createSemestre(SemestreDTO semestreDTO) {
        Semestre semestre = mapToEntity(semestreDTO);
        Semestre saved = semestreRepository.save(semestre);
        return mapToDTO(saved);
    }

    @Override
    public SemestreDTO getSemestreById(String id) {
        Optional<Semestre> opt = semestreRepository.findById(id);
        return opt.map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<SemestreDTO> getAllSemestres() {
        return semestreRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SemestreDTO updateSemestre(String id, SemestreDTO semestreDTO) {
        Optional<Semestre> opt = semestreRepository.findById(id);
        if (opt.isPresent()) {
            Semestre semestre = mapToEntity(semestreDTO);
            semestre.setId(id);
            Semestre updated = semestreRepository.save(semestre);
            return mapToDTO(updated);
        }
        return null;
    }

    @Override
    public void deleteSemestre(String id) {
        semestreRepository.deleteById(id);
    }
}