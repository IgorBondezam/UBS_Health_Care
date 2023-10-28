package com.care.health.ubs.model.domain;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Paciente {

    @Id
    private String id;
    private Pessoa pessoa;
}
