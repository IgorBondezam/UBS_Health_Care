package com.care.health.ubs.model.repository;

import com.care.health.ubs.model.domain.Contato;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends MongoRepository<Contato, String> {

}
