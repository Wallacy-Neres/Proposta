package br.com.zup.proposta.port.impl;

import br.com.zup.proposta.adapters.database.entities.Proposta;
import br.com.zup.proposta.adapters.database.repository.PropostaRepository;
import br.com.zup.proposta.enums.StatusProposta;
import br.com.zup.proposta.port.interfaces.PropostaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PropostaPortImpl implements PropostaPort {

    @Autowired
    private PropostaRepository propostaRepository;

    @Override
    public void salvarProposta(Proposta proposta) {
        propostaRepository.save(proposta);
    }

    @Override
    public void atualizaProposta(StatusProposta status, String documento) {
        propostaRepository.atualizaStatusProposta(status, documento);
    }

    @Override
    public Optional<Proposta> findByDocumento(String documento) {
        return propostaRepository.findByDocumento(documento);
    }

    @Override
    public List<Proposta> buscaPorPropostasElegiveis() {
        return propostaRepository.buscaPorPropostaElegiveis();
    }
}
