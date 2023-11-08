package com.care.health.ubs.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Receita {

    @Id
    private String id = new ObjectId().toString();

    private Remedio remedio;
    private String prescricao;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;
    private Integer intervaloHorario; // 8 em 8 horas
    private Integer quantidadePorDia;
    private Boolean receitaUsada;
}
