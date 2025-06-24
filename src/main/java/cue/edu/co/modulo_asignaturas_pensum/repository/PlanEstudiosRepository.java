package cue.edu.co.modulo_asignaturas_pensum.repository;

import cue.edu.co.modulo_asignaturas_pensum.model.PlanEstudios;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanEstudiosRepository extends MongoRepository<PlanEstudios, String> {
}