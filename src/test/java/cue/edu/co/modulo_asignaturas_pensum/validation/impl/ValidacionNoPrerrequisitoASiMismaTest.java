package cue.edu.co.modulo_asignaturas_pensum.validation.impl;

import cue.edu.co.modulo_asignaturas_pensum.validation.ValidationException;
import cue.edu.co.modulo_asignaturas_pensum.dto.AsignaturaDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionNoPrerrequisitoASiMismaTest {
    @Test
    void validaCorrecto() {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId("123");
        dto.setPrerrequisitos(Arrays.asList("234", "345"));

        assertDoesNotThrow(() -> new ValidacionNoPrerrequisitoASiMisma().validate(dto));
    }

    @Test
    void lanzaErrorSiPrerrequisitoASiMisma() {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId("999");
        dto.setPrerrequisitos(Arrays.asList("888", "999")); // Mismo ID

        assertThrows(ValidationException.class, () -> new ValidacionNoPrerrequisitoASiMisma().validate(dto));
    }
}