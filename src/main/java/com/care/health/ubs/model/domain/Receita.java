package com.care.health.ubs.model.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Receita {
    private Remedio remedio;
    private String prescricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer intervaloHorario; // 8 em 8 horas
    private Integer quantidadePorDia;
    private Boolean receitaUsada;
}
