package com.care.health.ubs.model.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SexoEnum {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_INFORMAR("Prefiro não informar");

    private final String descricao;
}
