package br.com.zup.proposta.port.interfaces;

import br.com.zup.proposta.adapters.database.entities.Proposta;

import java.util.Optional;

public interface PropostaPort {
    void salvarProposta(Proposta proposta);

    Optional<Proposta> findByDocumento(String documento);
}
