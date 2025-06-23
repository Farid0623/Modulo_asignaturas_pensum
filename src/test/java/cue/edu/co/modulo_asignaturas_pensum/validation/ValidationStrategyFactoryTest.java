package cue.edu.co.modulo_asignaturas_pensum.validation;

import cue.edu.co.modulo_asignaturas_pensum.validation.impl.ValidacionHorasVsCreditos;
import cue.edu.co.modulo_asignaturas_pensum.validation.impl.ValidacionNoPrerrequisitoASiMisma;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationStrategyFactoryTest {
    @Test
    void obtieneEstrategiasPorRolAdmin() {
        List<AsignaturaValidationStrategy> strategies = ValidationStrategyFactory.getStrategiesByRole("ADMIN");
        assertTrue(strategies.stream().anyMatch(s -> s instanceof ValidacionHorasVsCreditos));
        assertTrue(strategies.stream().anyMatch(s -> s instanceof ValidacionNoPrerrequisitoASiMisma));
    }

    @Test
    void obtieneEstrategiasPorRolProfesor() {
        List<AsignaturaValidationStrategy> strategies = ValidationStrategyFactory.getStrategiesByRole("PROFESOR");
        assertTrue(strategies.stream().anyMatch(s -> s instanceof ValidacionHorasVsCreditos));
    }
}