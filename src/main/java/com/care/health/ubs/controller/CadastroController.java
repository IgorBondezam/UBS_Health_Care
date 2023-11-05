package com.care.health.ubs.controller;

import com.care.health.ubs.model.domain.Paciente;
import com.care.health.ubs.model.service.LoginService;
import com.care.health.ubs.model.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class CadastroController {

    @Autowired
    private LoginService service;

    @Autowired
    private PacienteService pacienteService;


    @PostMapping("/cadastrar/pessoa")
    public String cadastrar(@ModelAttribute(name = "novoPaciente") Paciente paciente, Model model){
        if(pacienteService.isCpfJaCadastrado(paciente.getPessoa().getCpfCnpj())) {
            model.addAttribute("error", "Erro ao criar Paciente");
            return "Pages/Cadastro/cadastro";
        }
        pacienteService.criarPaciente(paciente);
        return "redirect:/login";
    }
}
