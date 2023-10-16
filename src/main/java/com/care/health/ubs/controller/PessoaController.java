package com.care.health.ubs.controller;

import com.care.health.ubs.model.domain.Contato;
import com.care.health.ubs.model.domain.Pessoa;
import com.care.health.ubs.model.repository.ContatoRepository;
import com.care.health.ubs.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public void addPessoa(){
        Contato c = contatoRepository.save(new Contato(null, "123459"));
//        List<Pessoa> p = repository.findByNomeAndContato_IdIsNotNull("Igooooor");
        repository.save(new Pessoa(null, "Igooooor", "123", c, LocalDate.now(), "M"));
        c.setTelefone("12222222");
        contatoRepository.save(c);



    }
}
