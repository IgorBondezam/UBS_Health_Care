package com.care.health.ubs.model.repository;

import com.care.health.ubs.model.domain.Medico;
import com.care.health.ubs.model.domain.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {

    List<Pessoa> findByNomeAndContato_IdIsNotNull(String nome);
}
