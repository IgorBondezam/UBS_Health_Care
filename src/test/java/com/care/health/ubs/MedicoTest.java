package com.care.health.ubs;

import com.care.health.ubs.model.domain.*;
import com.care.health.ubs.model.domain.enums.SexoEnum;
import com.care.health.ubs.model.service.MedicoService;
import com.care.health.ubs.model.service.PacienteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MedicoTest {

    @Autowired
    private MedicoService service;

    private Medico medicoMockadoId;

    @BeforeAll
    public void setup(){
        medicoMockadoId = new Medico(null,"11121-PB", new Pessoa(null, "Igor Mandela", LocalDate.of(2004, 7, 19), SexoEnum.NAO_INFORMAR, "123.123.123-12", new Contato(null, "44 99999-9999"), new Login(null, "123.123.123-12", "senha123"), LocalDate.of(2015, 10, 12) ));
        service.criarMedico(medicoMockadoId);
    }

    @AfterAll
    public void teardown(){
        service.deletarMedico(medicoMockadoId);
    }

    @Test
    public void findMedicoByLoginTest(){
        Assertions.assertEquals(service.findMedicoByLogin(medicoMockadoId.getPessoa().getLogin().getLogin(),
                                                            medicoMockadoId.getPessoa().getLogin().getPassword())
                                                                        .getPessoa().getCpfCnpj(),
                                                                         medicoMockadoId.getPessoa().getCpfCnpj());
    }

    @Test
    public void deletarMedicoTest(){
        Medico medico = new Medico(null,"11121-PB", new Pessoa(null, "Igor Mandela", LocalDate.of(2004, 7, 19), SexoEnum.NAO_INFORMAR, "213.213.213-21", new Contato(null, "44 99999-9999"), new Login(null, "213.213.213-21", "senhaParaTesteDeDeletarMedico"), LocalDate.of(2015, 10, 12) ));
        service.criarMedico(medico);
        service.deletarMedico(medico);
        Assertions.assertNull(service.findMedicoByLogin(medico.getPessoa().getLogin().getLogin(), medico.getPessoa().getLogin().getPassword()));
    }

}
