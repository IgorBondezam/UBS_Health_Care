package com.care.health.ubs.model.repository;

import com.care.health.ubs.model.domain.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {

    //List<Pessoa> findByNomeAndContato_IdIsNotNull(String nome);

    boolean existsPacienteByPessoa_CpfCnpjEquals(String cpfCnpj);
    Paciente findPacienteByPessoa_Login_LoginAndPessoa_Login_Password(String pessoa_login_login,
                                                                      String pessoa_login_password);
}
