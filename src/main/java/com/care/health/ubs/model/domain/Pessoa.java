package com.care.health.ubs.model.domain;

import com.care.health.ubs.model.domain.enums.SexoEnum;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Pessoa implements Serializable {

    @Id
    private String id;
    private String nome;
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private LocalDate dataNascimento;
    private SexoEnum sexoEnum;
    private String cpfCnpj;
    private Contato contato;
    private Login login = new Login();
    private List<String> alergias;
    private LocalDate dataCadastro = LocalDate.now();

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        this.login.setLogin(cpfCnpj);
    }
}