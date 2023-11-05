package com.care.health.ubs.model.service;

import com.care.health.ubs.model.domain.Paciente;
import com.care.health.ubs.model.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

    public List<Paciente> findAll(){
        return repository.findAll();
    }

    public Paciente findById(String  id){
        return repository.findById(id).get();
    }

    public void criarPaciente(Paciente Paciente){
        repository.save(Paciente);
    }

    public boolean isCpfJaCadastrado(String cpfCnpj){
        return repository.existsPacienteByPessoa_CpfCnpjEquals(cpfCnpj);
    }

}
