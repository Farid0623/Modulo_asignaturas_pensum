package cue.edu.co.modulo_asignaturas_pensum.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "asignaturas")
public class Asignatura {
    @Id
    private String id;
    private String codigo;
    private String nombre;
    private Integer creditos;
    private Integer horasTeoricas;
    private Integer horasPracticas;
    private String descripcion;
    private Boolean activa;
    private EstadoAsignatura estado;
    private List<String> prerrequisitos;
    private List<String> horarios;
    private Integer numeroSemestre;

    // Getters y Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCreditos() {
        return creditos;
    }
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    public Integer getHorasTeoricas() {
        return horasTeoricas;
    }
    public void setHorasTeoricas(Integer horasTeoricas) {
        this.horasTeoricas = horasTeoricas;
    }
    public Integer getHorasPracticas() {
        return horasPracticas;
    }
    public void setHorasPracticas(Integer horasPracticas) {
        this.horasPracticas = horasPracticas;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Boolean getActiva() {
        return activa;
    }
    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
    public EstadoAsignatura getEstado() {
        return estado;
    }
    public void setEstado(EstadoAsignatura estado) {
        this.estado = estado;
    }
    public List<String> getPrerrequisitos() {
        return prerrequisitos;
    }
    public void setPrerrequisitos(List<String> prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }
    public List<String> getHorarios() {
        return horarios;
    }
    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }
    public Integer getNumeroSemestre() {
        return numeroSemestre;
    }
    public void setNumeroSemestre(Integer numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public static class EstadoAsignatura {
        private String _class;

        public String get_class() {
            return _class;
        }
        public void set_class(String _class) {
            this._class = _class;
        }
    }
}
