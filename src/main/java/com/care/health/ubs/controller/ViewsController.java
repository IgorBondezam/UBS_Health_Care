package com.care.health.ubs.controller;

import com.care.health.ubs.UbsHealthCareApplication;
import com.care.health.ubs.model.service.MedicoService;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class ViewsController {

    @Autowired
    private MedicoService service;

    @GetMapping(path = "/start")
    public String telaInicial(Model model){
        model.addAttribute("medicos", service.findAll());
//        UbsHealthCareApplication.loginTokens.add("teste");
        return "Pages/Home/telaInicial";
    }

    @GetMapping(path = "/login")
    public String login(Model model){
        model.addAttribute("medicos", service.findAll());

        return "Pages/Login/login";
    }

    @GetMapping(path = "/cadastro")
    public String cadastro(Model model){
        model.addAttribute("medicos", service.findAll());
        return "Pages/Cadastro/cadastro";
    }

    @GetMapping(path = "/calendario")
    public String calendario(Model model){
        model.addAttribute("medicos", service.findAll());
        return "Pages/Calendario/calendario";
    }

    @GetMapping(path = "/prescricao")
    public String prescricao(){
        return "Pages/Prescricao/prescricao";
    }

    @GetMapping(path = "/teste")
    public String telaTeste(){
        return "teste";
    }
}
