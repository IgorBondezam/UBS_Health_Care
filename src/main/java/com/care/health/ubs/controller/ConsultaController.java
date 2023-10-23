package com.care.health.ubs.controller;

import com.care.health.ubs.model.domain.Consulta;
import com.care.health.ubs.model.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(name = "consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @GetMapping
    public List<Consulta> listarConsultas() {
        return service.findAll();
    }

    @GetMapping(name = "/{id}")
    public Consulta listarConsultaPorId(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping(name = "medico/{id}")
    public List<Consulta> listarConsultaPorMedicoId(@PathVariable("id") String id) {
        return service.findByMedico(id);
    }

    @GetMapping(name = "paciente/{id}")
    public List<Consulta> listarConsultaPorPacienteId(@PathVariable("id") String id) {
        return service.findByPaciente(id);
    }

    @PostMapping
    public void criarConsulta(Consulta Consulta) {
        service.criarConsulta(Consulta);
    }
}
