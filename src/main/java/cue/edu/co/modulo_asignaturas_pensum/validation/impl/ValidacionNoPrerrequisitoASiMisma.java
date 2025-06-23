package cue.edu.co.modulo_asignaturas_pensum.validation.impl;

import cue.edu.co.modulo_asignaturas_pensum.dto.AsignaturaDTO;
import cue.edu.co.modulo_asignaturas_pensum.validation.AsignaturaValidationStrategy;
import cue.edu.co.modulo_asignaturas_pensum.validation.ValidationException;

import java.util.List;

public class ValidacionNoPrerrequisitoASiMisma implements AsignaturaValidationStrategy {
    @Override
    public void validate(AsignaturaDTO asignaturaDTO) throws ValidationException {
        List<String> prerequisitos = asignaturaDTO.getPrerrequisitos();
        if (prerequisitos != null && asignaturaDTO.getId() != null && prerequisitos.contains(asignaturaDTO.getId())) {
            throw new ValidationException("Una asignatura no puede ser prerrequisito de sí misma.");
        }
    }
}