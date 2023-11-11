package com.care.health.ubs.controller;

import com.care.health.ubs.UbsHealthCareApplication;
import com.care.health.ubs.model.service.MedicoService;
import com.care.health.ubs.model.service.ReceitaService;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class ViewsController {

    @Autowired
    private ReceitaService service;

    @GetMapping(path = "/telaInicial")
    public String telaInicial(Model model){
        if(UbsHealthCareApplication.loginTokens.isEmpty()){
            return "redirect:/login";
        }
        model.addAttribute("receitas",
                service.getAllReceitasByPaciente(UbsHealthCareApplication.loginTokens.get(0)));
        return "Pages/Home/telaInicial";
    }

    @GetMapping(path = "/login")
    public String login(){
        return "Pages/Login/login";
    }

    @GetMapping(path = "/cadastro")
    public String cadastro(){
        return "Pages/Cadastro/cadastro";
    }

    @GetMapping(path = "/calendario")
    public String calendario(){
        if(UbsHealthCareApplication.loginTokens.isEmpty()){
            return "redirect:/login";
        }
        return "Pages/Calendario/calendario";
    }

    @GetMapping(path = "/prescricao")
    public String prescricao(){
        if(UbsHealthCareApplication.loginTokens.isEmpty()){
            return "redirect:/login";
        }
        return "Pages/Prescricao/prescricao";
    }

    @GetMapping(path = "/configuracao")
    public String configuracao() {
        return "Pages/Configuracao/configuracao";
    }

    @GetMapping(path = "/receita/{id}")
    public String receita(Model model){
        if(UbsHealthCareApplication.loginTokens.isEmpty()){
            return "redirect:/login";
        }
        return "Pages/Receita/receita";

    }
    @GetMapping(path = "/teste")
    public String telaTeste(){
        return "teste";
    }
}
