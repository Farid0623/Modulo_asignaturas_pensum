package cue.edu.co.modulo_asignaturas_pensum.repository;

import cue.edu.co.modulo_asignaturas_pensum.model.Asignatura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends MongoRepository<Asignatura, String> {
}
