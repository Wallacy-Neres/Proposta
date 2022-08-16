package br.com.zup.proposta.usecase.impl;

import br.com.zup.proposta.adapters.database.converter.PropostaConverter;
import br.com.zup.proposta.adapters.database.entities.Proposta;
import br.com.zup.proposta.adapters.webservices.analise.ConsultaDadosSolicitante;
import br.com.zup.proposta.adapters.webservices.analise.converter.AnalisePropostaConverter;
import br.com.zup.proposta.adapters.webservices.analise.dto.AnalisePropostaRequest;
import br.com.zup.proposta.adapters.webservices.analise.dto.ResultadoAnalise;
import br.com.zup.proposta.dto.PropostaDTO;
import br.com.zup.proposta.dto.StatusProposta;
import br.com.zup.proposta.port.interfaces.PropostaPort;
import br.com.zup.proposta.usecase.interfaces.PropostaUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Component
public class PropostaUCImpl implements PropostaUC {

    @Autowired
    private PropostaConverter propostaConverter;

    @Autowired
    private PropostaPort port;

    @Autowired
    private ConsultaDadosSolicitante consultaDadosSolicitante;

    @Autowired
    private AnalisePropostaConverter analiseConverter;

    @Override
    public ResponseEntity<Object> excute(PropostaDTO propostaDTO, UriComponentsBuilder builder) {
        Proposta proposta = propostaConverter.converter(propostaDTO);
        Optional<Proposta> propostaBanco = port.findByDocumento(proposta.getDocumento());

        if(propostaBanco.isEmpty()){

            port.salvarProposta(proposta);
            URI uri = builder.path("/proposta/{id}").buildAndExpand(proposta.getId()).toUri();

            AnalisePropostaRequest request = analiseConverter.converter(proposta);
            ResultadoAnalise resultadoAnalise = consultaDadosSolicitante.solicitaAnaliseDeDados(request);

            if(resultadoAnalise.getResultadoSolicitacao().equals("SEM_RESTRICAO")){
                proposta.setStatusProposta(StatusProposta.ELEGIVEL);
                port.salvarProposta(proposta);
            }else if(resultadoAnalise.getResultadoSolicitacao().equals("COM_RESTRICAO")){
                proposta.setStatusProposta(StatusProposta.NAO_ELEGIVEL);
                port.salvarProposta(proposta);
            }

            return ResponseEntity.created(uri).build();
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

    }
}
