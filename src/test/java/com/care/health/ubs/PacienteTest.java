package com.care.health.ubs;

import com.care.health.ubs.model.domain.*;
import com.care.health.ubs.model.domain.enums.SexoEnum;
import com.care.health.ubs.model.service.PacienteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PacienteTest {

    @Autowired
    private PacienteService service;


    private Paciente pacienteMockadoId;

    @BeforeAll
    public void setup(){
        pacienteMockadoId = new Paciente(null, new Pessoa(null, "Igor Mandela", LocalDate.of(2004, 7, 19), SexoEnum.NAO_INFORMAR, "123.123.123-12", new Contato(null, "44 99999-9999"), new Login(null, "123.123.123-12", "senha123"), LocalDate.of(2015, 10, 12) ));
        service.criarPaciente(pacienteMockadoId);
    }

    @AfterAll
    public void teardown(){
        service.deletarPaciente(pacienteMockadoId);
    }

    @Test
    public void findPacienteByIdTest(){
        Assertions.assertEquals(service.findPacienteByLogin(pacienteMockadoId.getPessoa().getLogin().getLogin(),
                pacienteMockadoId.getPessoa().getLogin().getPassword()).getPessoa().getCpfCnpj(), pacienteMockadoId.getPessoa().getCpfCnpj());
    }

    @Test
    public void isCpfJaCadastradoTest(){
        Assertions.assertTrue(service.isCpfJaCadastrado("123.123.123-12"));
    }

    @Test
    public void isCpfNaoCadastradoTest(){
        Assertions.assertFalse(service.isCpfJaCadastrado("066.710.130-63"));
    }

    @Test
    public void deletarPacienteTest(){
        Paciente paciente = new Paciente(null, new Pessoa(null, "Igor Mandela", LocalDate.of(2004, 7, 19), SexoEnum.NAO_INFORMAR, "321.321.321-32", new Contato(null, "44 99999-9999"), new Login(null, "321.321.321-32", "senhaTesteDoTesteDeDeletar"), LocalDate.of(2015, 10, 12) ));
        service.criarPaciente(paciente);
        service.deletarPaciente(paciente);
        Assertions.assertNull(service.findPacienteByLogin(paciente.getPessoa().getLogin().getLogin(), paciente.getPessoa().getLogin().getPassword()));
    }

}
