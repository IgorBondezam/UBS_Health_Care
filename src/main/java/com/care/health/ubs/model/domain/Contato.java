package com.care.health.ubs.model.domain;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Contato implements Serializable {

    @Id
    private String id;
    private String telefone;

}
