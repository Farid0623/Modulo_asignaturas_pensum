package cue.edu.co.modulo_asignaturas_pensum.service.impl;

import cue.edu.co.modulo_asignaturas_pensum.dto.AsignaturaDTO;
import cue.edu.co.modulo_asignaturas_pensum.model.Asignatura;
import cue.edu.co.modulo_asignaturas_pensum.service.AsignaturaService   ;
import cue.edu.co.modulo_asignaturas_pensum.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    private AsignaturaDTO mapToDTO(Asignatura asignatura) {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(asignatura.getId());
        dto.setCodigo(asignatura.getCodigo());
        dto.setNombre(asignatura.getNombre());
        dto.setCreditos(asignatura.getCreditos());
        dto.setHorasTeoricas(asignatura.getHorasTeoricas());
        dto.setHorasPracticas(asignatura.getHorasPracticas());
        dto.setDescripcion(asignatura.getDescripcion());
        dto.setActiva(asignatura.getActiva());
        dto.setEstado(asignatura.getEstado() != null ? asignatura.getEstado().get_class() : null);
        dto.setPrerrequisitos(asignatura.getPrerrequisitos());
        dto.setHorarios(asignatura.getHorarios());
        dto.setNumeroSemestre(asignatura.getNumeroSemestre());
        return dto;
    }

    private Asignatura mapToEntity(AsignaturaDTO dto) {
        Asignatura asignatura = new Asignatura();
        asignatura.setId(dto.getId());
        asignatura.setCodigo(dto.getCodigo());
        asignatura.setNombre(dto.getNombre());
        asignatura.setCreditos(dto.getCreditos());
        asignatura.setHorasTeoricas(dto.getHorasTeoricas());
        asignatura.setHorasPracticas(dto.getHorasPracticas());
        asignatura.setDescripcion(dto.getDescripcion());
        asignatura.setActiva(dto.getActiva());

        Asignatura.EstadoAsignatura estado = new Asignatura.EstadoAsignatura();
        estado.set_class(dto.getEstado());
        asignatura.setEstado(estado);

        asignatura.setPrerrequisitos(dto.getPrerrequisitos());
        asignatura.setHorarios(dto.getHorarios());
        asignatura.setNumeroSemestre(dto.getNumeroSemestre());
        return asignatura;
    }

    @Override
    public AsignaturaDTO createAsignatura(AsignaturaDTO asignaturaDTO) {
        Asignatura asignatura = mapToEntity(asignaturaDTO);
        Asignatura saved = asignaturaRepository.save(asignatura);
        return mapToDTO(saved);
    }

    @Override
    public AsignaturaDTO getAsignaturaById(String id) {
        Optional<Asignatura> opt = asignaturaRepository.findById(id);
        return opt.map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<AsignaturaDTO> getAllAsignaturas() {
        return asignaturaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsignaturaDTO updateAsignatura(String id, AsignaturaDTO asignaturaDTO) {
        Optional<Asignatura> opt = asignaturaRepository.findById(id);
        if (opt.isPresent()) {
            Asignatura asignatura = mapToEntity(asignaturaDTO);
            asignatura.setId(id);
            Asignatura updated = asignaturaRepository.save(asignatura);
            return mapToDTO(updated);
        }
        return null;
    }

    @Override
    public void deleteAsignatura(String id) {
        asignaturaRepository.deleteById(id);
    }
}
