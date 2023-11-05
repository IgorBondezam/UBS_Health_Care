package com.care.health.ubs.model.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SexoEnum {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String descricao;
}
