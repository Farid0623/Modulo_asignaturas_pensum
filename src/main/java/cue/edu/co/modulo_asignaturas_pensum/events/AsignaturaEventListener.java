package cue.edu.co.modulo_asignaturas_pensum.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaEventListener {
    @EventListener
    public void handleAsignaturaChanged(AsignaturaChangedEvent event) {
        // Aquí puedes guardar en BD, log, enviar email, etc.
        System.out.printf("Asignatura %s: %s por %s%n", event.getAction(), event.getAsignatura().getNombre(), event.getUsuario());
    }
}