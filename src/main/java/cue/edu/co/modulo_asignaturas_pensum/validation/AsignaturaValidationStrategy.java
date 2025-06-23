package cue.edu.co.modulo_asignaturas_pensum.validation;

import cue.edu.co.modulo_asignaturas_pensum.dto.AsignaturaDTO;

public interface AsignaturaValidationStrategy {
    void validate(AsignaturaDTO asignaturaDTO) throws ValidationException;
}