package cue.edu.co.modulo_asignaturas_pensum.events;

import org.springframework.context.ApplicationEvent;
import cue.edu.co.modulo_asignaturas_pensum.model.Asignatura;

public class AsignaturaChangedEvent extends ApplicationEvent {
    private final Asignatura asignatura;
    private final String action;
    private final String usuario;

    public AsignaturaChangedEvent(Object source, Asignatura asignatura, String action, String usuario) {
        super(source);
        this.asignatura = asignatura;
        this.action = action;
        this.usuario = usuario;
    }

    public Asignatura getAsignatura() { return asignatura; }
    public String getAction() { return action; }
    public String getUsuario() { return usuario; }
}