package br.com.zup.proposta.adapters.database.converter;

import br.com.zup.proposta.adapters.database.entities.Proposta;
import br.com.zup.proposta.dto.PropostaDTO;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class PropostaConverter {

    public Proposta converter(PropostaDTO propostaDTO) {
        return new Proposta(propostaDTO.getDocumento(),
                propostaDTO.getEmail(),
                propostaDTO.getNome(),
                propostaDTO.getEndereco(),
                propostaDTO.getSalario());
    }

    public PropostaDTO converterBytesToPropostaDTO(byte[] objeto) {

        Gson gson = new Gson();
        String byteParaString = new String(objeto, StandardCharsets.UTF_8);
        return gson.fromJson(byteParaString, PropostaDTO.class);

    }
}
