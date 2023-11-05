package com.care.health.ubs.controller;

import com.care.health.ubs.UbsHealthCareApplication;
import com.care.health.ubs.model.domain.Consulta;
import com.care.health.ubs.model.service.ConsultaService;
import com.care.health.ubs.model.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Consulta> listarConsultas() {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public Consulta listarConsultaPorId(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping(path = "medico/{id}")
    public List<Consulta> listarConsultaPorMedicoId(@PathVariable("id") String id) {
        return service.findByMedico(id);
    }

    @GetMapping(path = "paciente/{id}")
    public List<Consulta> listarConsultaPorPacienteId(@PathVariable("id") String id) {
        return service.findByPaciente(id);
    }

    @PostMapping
    public void criarConsulta(@RequestBody Consulta consulta) {
        consulta.setPaciente(pacienteService.findById(UbsHealthCareApplication.loginTokens.get(0)));
        service.criarConsulta(consulta);
    }
}
