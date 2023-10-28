package com.care.health.ubs.controller;

import com.care.health.ubs.model.domain.Login;
import com.care.health.ubs.model.domain.Paciente;
import com.care.health.ubs.model.domain.enums.TipoAcessoEnum;
import com.care.health.ubs.model.service.LoginService;
import com.care.health.ubs.model.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/acessar")
    public String logar(@ModelAttribute(name = "loginForm") Login login, Model model){
//        Login login = new Login();
//        login.setLogin("13980194964");
//        login.setPassword("1234");
        if(service.logarUsuario(login, TipoAcessoEnum.MEDICO)) {
            return "Pages/Home/telaInicial";
        }
        return "Pages/Cadastro/cadastro";
    }

    @PostMapping("/cadastrar/pessoa")
    public String cadastrar(@ModelAttribute(name = "novoPaciente") Paciente paciente, Model model){
        if(Objects.isNull(paciente.getPessoa().getLogin().getPassword())) {
            model.addAttribute("error", "Erro ao criar Paciente");
            return "Pages/Cadastro/cadastro";
        }
        pacienteService.criarPaciente(paciente);
        return "Pages/Home/telaInicial";
    }
}
