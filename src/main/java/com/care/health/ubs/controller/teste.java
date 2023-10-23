package com.care.health.ubs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class teste {

    @GetMapping("/teste")
    public String create(){
        return "teste";
    }
}
