package br.com.zup.proposta.adapters.webservices.analise.converter;

import br.com.zup.proposta.adapters.database.entities.Proposta;
import br.com.zup.proposta.adapters.webservices.analise.dto.AnalisePropostaRequest;
import org.springframework.stereotype.Component;

@Component
public class AnalisePropostaConverter {
    public AnalisePropostaRequest converter(Proposta proposta) {
        return new AnalisePropostaRequest(
                proposta.getDocumento(),
                proposta.getNome(),
                proposta.getId().toString());
    }
}
