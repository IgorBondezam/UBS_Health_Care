package com.care.health.ubs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {
    @GetMapping(path = "/home")
    public String telaInicial(){
        return "telaInicial";
    }
}
