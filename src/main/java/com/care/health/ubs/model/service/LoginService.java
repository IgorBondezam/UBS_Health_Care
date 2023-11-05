package com.care.health.ubs.model.service;

import com.care.health.ubs.UbsHealthCareApplication;
import com.care.health.ubs.model.domain.*;
import com.care.health.ubs.model.domain.enums.TipoAcessoEnum;
import com.care.health.ubs.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Login findById(String id){
        return repository.findById(id).orElse(null);
    }

    public boolean logarUsuario(Login login, TipoAcessoEnum acesso){
        if(acesso.equals(TipoAcessoEnum.MEDICO)) {
            Medico medico = medicoRepository.findMedicoByPessoa_Login_LoginAndPessoa_Login_Password(login.getLogin(),
                    login.getPassword());
            if(Objects.nonNull(medico)) {
                UbsHealthCareApplication.loginTokens.add(medico.getId());
                return true;
            }
            return false;
        }
        Paciente paciente = pacienteRepository.findPacienteByPessoa_Login_LoginAndPessoa_Login_Password(login.getLogin(),
                login.getPassword());
        if(Objects.nonNull(paciente)) {
            UbsHealthCareApplication.loginTokens.add(paciente.getId());
            return true;
        }
        return false;
    }

    public Login save(Login login){
        return repository.save(login);
    }

}
