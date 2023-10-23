package com.care.health.ubs.model.repository;

import com.care.health.ubs.model.domain.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends MongoRepository<Consulta, String> {

    List<Consulta> findByPaciente_Id(String id);
    List<Consulta> findByMedico_Id(String id);

}
