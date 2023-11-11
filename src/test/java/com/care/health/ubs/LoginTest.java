package com.care.health.ubs;

import com.care.health.ubs.model.domain.*;
import com.care.health.ubs.model.domain.enums.SexoEnum;
import com.care.health.ubs.model.domain.enums.TipoAcessoEnum;
import com.care.health.ubs.model.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private LoginService service;

    private Paciente pacienteMockadoId;
    private Medico medicoMockadoId;

    @BeforeAll
    public void setup(){
        pacienteMockadoId = new Paciente(null, new Pessoa(null, "Igor Mandela", LocalDate.of(2004, 7, 19), SexoEnum.NAO_INFORMAR, "123.123.123-12", new Contato(null, "44 99999-9999"), new Login(null, "123.123.123-12", "senha123"), LocalDate.of(2015, 10, 12) ));
        medicoMockadoId = new Medico(null,"11121-PB", new Pessoa(null, "Igor Mandela", LocalDate.of(2004, 7, 19), SexoEnum.NAO_INFORMAR, "123.123.123-12", new Contato(null, "44 99999-9999"), new Login(null, "123.123.123-12", "senha123"), LocalDate.of(2015, 10, 12) ));
        pacienteService.criarPaciente(pacienteMockadoId);
        medicoService.criarMedico(medicoMockadoId);
    }

    @AfterAll
    public void teardown(){
        pacienteService.deletarPaciente(pacienteMockadoId);
        medicoService.deletarMedico(medicoMockadoId);
    }

    @Test
    public void logarContaMedicoTest(){
        Assertions.assertTrue(service.logarUsuario(medicoMockadoId.getPessoa().getLogin(), TipoAcessoEnum.MEDICO));
    }

    @Test
    public void logarErradoContaMedicoTest(){
        medicoMockadoId.getPessoa().getLogin().setPassword("senhaErrada");
        Assertions.assertFalse(service.logarUsuario(medicoMockadoId.getPessoa().getLogin(), TipoAcessoEnum.MEDICO));
    }

    @Test
    public void logarContaPacienteTest(){
        Assertions.assertTrue(service.logarUsuario(pacienteMockadoId.getPessoa().getLogin(), TipoAcessoEnum.PACIENTE));
    }

    @Test
    public void logarErradoContaPacienteTest(){
        pacienteMockadoId.getPessoa().getLogin().setPassword("senhaErrada");
        Assertions.assertFalse(service.logarUsuario(pacienteMockadoId.getPessoa().getLogin(), TipoAcessoEnum.PACIENTE));
    }

}
