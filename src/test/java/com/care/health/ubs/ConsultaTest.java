package com.care.health.ubs;

import com.care.health.ubs.model.domain.*;
import com.care.health.ubs.model.domain.enums.SexoEnum;
import com.care.health.ubs.model.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConsultaTest {

    @Autowired
    private ConsultaService service;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    private Consulta consultaMockadoId;
    private Paciente pacienteMockadoId;
    private Medico medicoMockadoId;
    private List<Receita> receitasMock;

    @BeforeAll
    public void setup() {
        pacienteMockadoId = new Paciente(null, new Pessoa(null, "Igor Mandela", LocalDate.of(2004, 7, 19), SexoEnum.NAO_INFORMAR, "123.123.123-12", new Contato(null, "44 99999-9999"), new Login(null, "123.123.123-12", "senha123"), LocalDate.of(2015, 10, 12)));
        medicoMockadoId = new Medico(null, "11121-PB", new Pessoa(null, "Igor Mandela", LocalDate.of(2004, 7, 19), SexoEnum.NAO_INFORMAR, "123.123.123-12", new Contato(null, "44 99999-9999"), new Login(null, "123.123.123-12", "senha123"), LocalDate.of(2015, 10, 12)));
        pacienteService.criarPaciente(pacienteMockadoId);
        medicoService.criarMedico(medicoMockadoId);
        pacienteMockadoId = pacienteService.findPacienteByLogin(pacienteMockadoId.getPessoa().getLogin().getLogin(),
                pacienteMockadoId.getPessoa().getLogin().getPassword());
        medicoMockadoId = medicoService.findMedicoByLogin(medicoMockadoId.getPessoa().getLogin().getLogin(),
                medicoMockadoId.getPessoa().getLogin().getPassword());

        receitasMock = List.of(
                new Receita(null, new Remedio(null, "Nimisulida", 125.5D, 12.0D, true), "Tomar a cada 6 hora para melhorar a dor de cabeça, Assinado: Igor",
                        LocalDate.of(2014, 7, 19), LocalDate.of(2004, 7, 23), 6, 4, true),
                new Receita(null, new Remedio(null, "Nimisulida", 125.5D, 12.0D, true), "Tomar a cada 6 hora para melhorar a dor de cabeça, outra receita caso precise de mais, Assinado: Igor",
                        LocalDate.of(2014, 7, 19), LocalDate.of(2004, 7, 23), 6, 4, false),
                new Receita(null, new Remedio(null, "Paracetamol", 125.5, 12.0, false), "Tomar a cada 12 hora para melhorar a dor de cabeça caso o nimisulida não resolva, Assinado: Igor",
                        LocalDate.of(2014, 7, 19), LocalDate.of(2004, 7, 23), 6, 4, false));
        consultaMockadoId = new Consulta(null, pacienteMockadoId, medicoMockadoId, LocalDate.of(2014, 7, 19),
                receitasMock);
        service.criarConsulta(consultaMockadoId);
    }

    @Test
    public void findConsultaByPacienteTest() {
        Consulta consulta = service.findByPaciente(pacienteMockadoId.getId()).get(0);
        Assertions.assertEquals( LocalDate.of(2014, 7, 19),consulta.getDataConsulta());
        Assertions.assertEquals( pacienteMockadoId.getPessoa().getCpfCnpj(), consulta.getPaciente().getPessoa().getCpfCnpj());
        Assertions.assertEquals( medicoMockadoId.getPessoa().getCpfCnpj(), consulta.getMedico().getPessoa().getCpfCnpj());
    }


    @Test
    public void findConsultaByMedicoTest() {
        Consulta consulta = service.findByMedico(medicoMockadoId.getId()).get(0);
        Assertions.assertEquals( LocalDate.of(2014, 7, 19),consulta.getDataConsulta());
        Assertions.assertEquals( pacienteMockadoId.getPessoa().getCpfCnpj(), consulta.getPaciente().getPessoa().getCpfCnpj());
        Assertions.assertEquals( medicoMockadoId.getPessoa().getCpfCnpj(), consulta.getMedico().getPessoa().getCpfCnpj());
    }

    @AfterAll
    public void teardown() {

        pacienteService.deletarPaciente(pacienteMockadoId);
        medicoService.deletarMedico(medicoMockadoId);
        service.deletarConsulta(consultaMockadoId);
    }
}
