package cue.edu.co.modulo_asignaturas_pensum.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "semestres")
public class Semestre {
    @Id
    private String id;
    private Integer numero;
    private String nombre;
    private String descripcion;

    // Guardaremos sólo los IDs de las asignaturas (puedes usar @DBRef si prefieres, pero se recomienda solo IDs)
    private List<String> asignaturas;

    private String planEstudiosId;

    // Getters y Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<String> getAsignaturas() {
        return asignaturas;
    }
    public void setAsignaturas(List<String> asignaturas) {
        this.asignaturas = asignaturas;
    }
    public String getPlanEstudiosId() {
        return planEstudiosId;
    }
    public void setPlanEstudiosId(String planEstudiosId) {
        this.planEstudiosId = planEstudiosId;
    }
}