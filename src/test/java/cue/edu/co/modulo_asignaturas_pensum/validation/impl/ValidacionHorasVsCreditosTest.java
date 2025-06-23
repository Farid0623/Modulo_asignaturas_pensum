package cue.edu.co.modulo_asignaturas_pensum.validation.impl;

import cue.edu.co.modulo_asignaturas_pensum.validation.ValidationException;
import cue.edu.co.modulo_asignaturas_pensum.dto.AsignaturaDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionHorasVsCreditosTest {
    @Test
    void validaCorrecto() {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setCreditos(3);
        dto.setHorasTeoricas(24);
        dto.setHorasPracticas(24); // 24+24=48 == 3*16

        assertDoesNotThrow(() -> new ValidacionHorasVsCreditos().validate(dto));
    }

    @Test
    void lanzaErrorSiNoCoincide() {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setCreditos(2);
        dto.setHorasTeoricas(5);
        dto.setHorasPracticas(12);

        assertThrows(ValidationException.class, () -> new ValidacionHorasVsCreditos().validate(dto));
    }
}