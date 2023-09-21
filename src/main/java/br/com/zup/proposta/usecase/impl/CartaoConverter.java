package br.com.zup.proposta.usecase.impl;

import br.com.zup.proposta.adapters.database.entities.Cartao;
import br.com.zup.proposta.adapters.database.entities.Proposta;
import br.com.zup.proposta.adapters.webservices.cartoes.dto.RetornoCriacaoCartaoRequest;
import org.springframework.stereotype.Component;

@Component
public class CartaoConverter {
    public Cartao converter(RetornoCriacaoCartaoRequest dto, Proposta proposta) {
        return new Cartao(dto.getId(), dto.getEmitidoEm(), dto.getTitular(), dto.getLimite(), proposta);
    }
}
