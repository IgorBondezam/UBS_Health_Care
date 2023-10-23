package com.care.health.ubs.model.domain;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
public class Consulta {

    @Id
    private String id;
    private Paciente paciente;
    private Medico medico;
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private LocalDate dataConsulta;
    private List<Receita> receitas;
}
