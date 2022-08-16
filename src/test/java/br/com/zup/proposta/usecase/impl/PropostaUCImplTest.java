//package br.com.zup.proposta.usecase.impl;
//
//import br.com.zup.proposta.adapters.database.converter.PropostaConverter;
//import br.com.zup.proposta.adapters.database.entities.Proposta;
//import br.com.zup.proposta.dto.PropostaDTO;
//import br.com.zup.proposta.port.interfaces.PropostaPort;
//import br.com.zup.proposta.usecase.interfaces.PropostaUC;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.math.BigDecimal;
//import java.net.URI;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@RunWith(MockitoJUnitRunner.class)
//class PropostaUCImplTest {
//
//    @InjectMocks
//    private PropostaUC propostaUC;
//
//    @Mock
//    private PropostaConverter propostaConverter;
//
//    @Mock
//    private PropostaPort port;
//
//
//
//
//    @Test
//    public void deve() {
//        UriComponentsBuilder builder = UriComponentsBuilder
//                .newInstance()
//                .scheme("http")
//                .host("localhost")
//                .port("8080");
//
//        URI uri = builder.path("/proposta/{id}").buildAndExpand(1L).toUri();
//        propostaUC.excute(propostaDTO, builder);
//        Mockito.verify(port, Mockito.times(1)).salvarProposta(Mockito.any());
//    }
//
//    PropostaDTO propostaDTO = new PropostaDTO(
//            "860.242.360-85",
//            "fulano@gmail.com",
//            "Fulano",
//            "Rua Tal",
//            new BigDecimal(1000.0));
//
//
////    Proposta proposta = new Proposta("860.242.360-85", "fulano@gmail.com", "Fulano", "Rua Tal", new BigDecimal(1000.0));
//
//}
