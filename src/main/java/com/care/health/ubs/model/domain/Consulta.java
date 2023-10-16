package com.care.health.ubs.model.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Consulta {

    private Paciente paciente;
    private Medico medico;

    private List<Receita> receitas;

    protected Paciente getPaciente(){
        return this.paciente;
    }
}
