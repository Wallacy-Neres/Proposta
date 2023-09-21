package br.com.zup.proposta.port.interfaces;

import br.com.zup.proposta.adapters.database.entities.Proposta;
import br.com.zup.proposta.enums.StatusProposta;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PropostaPort {
    void salvarProposta(Proposta proposta);


    void atualizaProposta(StatusProposta status, String documento);

    Optional<Proposta> findByDocumento(String documento);

    List<Proposta> buscaPorPropostasElegiveis();
}
