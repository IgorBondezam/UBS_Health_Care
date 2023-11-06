package com.care.health.ubs.model.domain;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medico {

    @Id
    private String id;

    private String crm;
    private String cid;
    private Pessoa pessoa;
}
