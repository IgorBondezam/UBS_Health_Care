package com.care.health.ubs.model.repository;

import com.care.health.ubs.model.domain.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {

    //List<Pessoa> findByNomeAndContato_IdIsNotNull(String nome);

    Medico findMedicoByPessoa_Login_LoginAndPessoa_Login_Password(String pessoa_login_login,
                                                                  String pessoa_login_password);
}
