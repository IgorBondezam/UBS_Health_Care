package com.care.health.ubs.controller;

import com.care.health.ubs.model.domain.Medico;
import com.care.health.ubs.model.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping
    public List<Medico> listarMedicos() {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public Medico listarMedicoPorId(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public void criarMedico(Medico medico) {
        service.criarMedico(medico);
    }
}
