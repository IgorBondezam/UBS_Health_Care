package com.care.health.ubs.model.service;

import com.care.health.ubs.model.domain.Consulta;
import com.care.health.ubs.model.domain.Receita;
import com.care.health.ubs.model.repository.ConsultaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReceitaService {

    private final ConsultaRepository repository;

    public List<Receita> getAllReceitasByPaciente(String id){
        List<Receita> receitas = new ArrayList<>();
        repository.findByPaciente_Id(id).forEach(c -> receitas.addAll(c.getReceitas()));
        return receitas;
    }
}
