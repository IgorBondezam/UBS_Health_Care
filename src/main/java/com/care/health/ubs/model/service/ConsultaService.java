package com.care.health.ubs.model.service;

import com.care.health.ubs.model.domain.Consulta;
import com.care.health.ubs.model.repository.ConsultaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultaService {

    private final ConsultaRepository repository;

    public List<Consulta> findAll(){
        return repository.findAll();
    }

    public Consulta findById(String  id){
        return repository.findById(id).get();
    }

    public List<Consulta> findByMedico(String id){
        return repository.findByMedico_Id(id);
    }

    public List<Consulta> findByPaciente(String id){
        return repository.findByPaciente_Id(id);
    }

    public void criarConsulta(Consulta Consulta){
        repository.save(Consulta);
    }


}
