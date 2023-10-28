package com.care.health.ubs.model.domain.enums;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TipoAcessoEnum {

    MEDICO(1L, "Médico"),
    PACIENTE(2L, "Paciente");

    private Long codigo;
    private String descricao;

}
