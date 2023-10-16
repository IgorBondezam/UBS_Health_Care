package com.care.health.ubs.model.domain;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Pessoa implements Serializable {

    @Id
    private String id;
    private String nome;
    private String cpfCnpj;
    private Contato contato;
    private LocalDate dataNascimento;
    private String genero;

}