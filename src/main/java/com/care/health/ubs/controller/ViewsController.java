package com.care.health.ubs.controller;

import com.care.health.ubs.model.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {

    @Autowired
    private MedicoService service;

    @GetMapping(path = "/home")
    public String telaInicial(Model model){
        model.addAttribute("medicos", service.findAll());
        return "Pages/Home/telaInicial";
    }

    @GetMapping()
    public String telaTeste(){
        return "teste";
    }
}
