package com.care.health.ubs.model.service;

import com.care.health.ubs.model.domain.Medico;
import com.care.health.ubs.model.repository.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicoService {

    private final MedicoRepository repository;

    public void criarMedico(Medico medico){
        repository.save(medico);
    }

    public void deletarMedico(Medico medico){
        repository.delete(medico);
    }

    public Medico findMedicoByLogin(String login, String password) {
        return repository.findMedicoByPessoa_Login_LoginAndPessoa_Login_Password(login, password);
    }
}
