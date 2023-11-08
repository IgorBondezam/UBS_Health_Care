package com.care.health.ubs.model.domain;

import jakarta.persistence.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Remedio {

    @Id
    private String id = new ObjectId().toString();

    private String nome;
    private Double volume;
    private Double massa;
    private boolean generico;

}
