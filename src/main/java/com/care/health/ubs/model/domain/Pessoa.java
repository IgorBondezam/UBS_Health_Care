package com.care.health.ubs.model.domain;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private LocalDate dataNascimento;
    private String genero;

}