package br.com.zup.proposta.adapters.database.converter;

import br.com.zup.proposta.adapters.database.entities.Proposta;
import br.com.zup.proposta.dto.PropostaDTO;
import org.springframework.stereotype.Component;

@Component
public class PropostaConverter {

    public Proposta converter(PropostaDTO propostaDTO) {
        return new Proposta(propostaDTO.getDocumento(),
                propostaDTO.getEmail(),
                propostaDTO.getNome(),
                propostaDTO.getEndereco(),
                propostaDTO.getSalario());
    }
}
