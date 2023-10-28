package com.care.health.ubs.controller;

import com.care.health.ubs.model.domain.Consulta;
import com.care.health.ubs.model.domain.Receita;
import com.care.health.ubs.model.service.ReceitaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Getter
@RequestMapping(path = "/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    private List<Receita> receitas= new ArrayList<>();

    @ModelAttribute("receitas")
    @GetMapping(path = "paciente/{id}")
    public List<Receita> listarConsultaPorPacienteId(@PathVariable("id") String id) {
        return service.getAllReceitasByPaciente(id);
    }
}
