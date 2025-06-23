package cue.edu.co.modulo_asignaturas_pensum.validation.impl;

import cue.edu.co.modulo_asignaturas_pensum.dto.AsignaturaDTO;
import cue.edu.co.modulo_asignaturas_pensum.validation.AsignaturaValidationStrategy;
import cue.edu.co.modulo_asignaturas_pensum.validation.ValidationException;

public class ValidacionHorasVsCreditos implements AsignaturaValidationStrategy {
    @Override
    public void validate(AsignaturaDTO asignaturaDTO) throws ValidationException {
        int totalHoras = asignaturaDTO.getHorasTeoricas() + asignaturaDTO.getHorasPracticas();
        int esperado = asignaturaDTO.getCreditos() * 16;
        if (totalHoras != esperado) {
            throw new ValidationException("La suma de horas teóricas y prácticas debe ser igual a créditos * 16.");
        }
    }
}