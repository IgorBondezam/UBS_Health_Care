package com.care.health.ubs.model.domain;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Medico {

    @Id
    private String id;
    private Pessoa pessoa;
}
