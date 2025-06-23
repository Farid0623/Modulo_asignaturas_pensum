package cue.edu.co.modulo_asignaturas_pensum.validation;

import cue.edu.co.modulo_asignaturas_pensum.validation.impl.ValidacionHorasVsCreditos;
import cue.edu.co.modulo_asignaturas_pensum.validation.impl.ValidacionNoPrerrequisitoASiMisma;

import java.util.ArrayList;
import java.util.List;

public class ValidationStrategyFactory {
    public static List<AsignaturaValidationStrategy> getStrategiesByRole(String rol) {
        List<AsignaturaValidationStrategy> strategies = new ArrayList<>();
        strategies.add(new ValidacionHorasVsCreditos());
        strategies.add(new ValidacionNoPrerrequisitoASiMisma());

        // Puedes agregar aquí más validaciones por rol si lo necesitas
        if ("ADMIN".equalsIgnoreCase(rol)) {
            // strategies.add(new ValidacionParaAdmin());
        }
        return strategies;
    }
}