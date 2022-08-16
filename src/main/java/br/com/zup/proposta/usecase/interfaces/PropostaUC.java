package br.com.zup.proposta.usecase.interfaces;

import br.com.zup.proposta.dto.PropostaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface PropostaUC {
    ResponseEntity<Object> excute(PropostaDTO propostaDTO, UriComponentsBuilder builder);
}
