package com.care.health.ubs.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Receita {
    private Remedio remedio;
    private String prescricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer intervaloHorario; // 8 em 8 horas
    private Integer quantidadePorDia;
    private Boolean receitaUsada;
}
