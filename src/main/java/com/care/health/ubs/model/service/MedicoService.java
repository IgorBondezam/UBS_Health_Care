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

    public List<Medico> findAll(){
        return repository.findAll();
    }

    public Medico findById(String  id){
        return repository.findById(id).get();
    }

    public void criarMedico(Medico medico){
        repository.save(medico);
    }


}
