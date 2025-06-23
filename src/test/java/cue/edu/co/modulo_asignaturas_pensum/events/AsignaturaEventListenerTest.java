package cue.edu.co.modulo_asignaturas_pensum.events;

import cue.edu.co.modulo_asignaturas_pensum.model.Asignatura;
import org.junit.jupiter.api.Test;

class AsignaturaEventListenerTest {

    @Test
    void handleAsignaturaChanged() {
        AsignaturaEventListener listener = new AsignaturaEventListener();
        Asignatura asignatura = new Asignatura();
        asignatura.setNombre("Matemáticas");

        AsignaturaChangedEvent event = new AsignaturaChangedEvent(this, asignatura, "CREADA", "admin");
        listener.handleAsignaturaChanged(event);
    }
}