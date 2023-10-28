package com.care.health.ubs.model.repository;

import com.care.health.ubs.model.domain.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<Login, String> {


}
