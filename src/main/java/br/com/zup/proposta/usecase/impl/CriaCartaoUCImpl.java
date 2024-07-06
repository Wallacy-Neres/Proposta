package br.com.zup.proposta.usecase.impl;

import br.com.zup.proposta.adapters.database.entities.Cartao;
import br.com.zup.proposta.adapters.database.entities.Proposta;
import br.com.zup.proposta.adapters.database.repository.PropostaRepository;
import br.com.zup.proposta.adapters.webservices.analise.dto.AnalisePropostaRequest;
import br.com.zup.proposta.adapters.webservices.cartoes.CriarCartao;
import br.com.zup.proposta.adapters.webservices.cartoes.dto.RetornoCriacaoCartaoRequest;
import br.com.zup.proposta.dto.CartaoDTO;
import br.com.zup.proposta.port.interfaces.PropostaPort;
import br.com.zup.proposta.usecase.interfaces.CriaCartaoUC;
import com.yusufaytas.dlock.TryLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Component
public class CriaCartaoUCImpl implements CriaCartaoUC {

    @Autowired
    private PropostaPort propostaPort;

    @Autowired
    private CriarCartao criarCartao;

    @Autowired
    private CartaoConverter cartaoConverter;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Scheduled(fixedDelayString = "${tempo.execucao}")
    @TryLock(name = "teste", owner = "dlock", lockFor = 1)
    public void criacartaoParaProposta() {

        logger.info("Inicio do Schedule para criacao do cartão para propostas elegiveis");

        var propostas = propostaPort.buscaPorPropostasElegiveis();

        propostas.forEach(proposta -> {
            var retornoCriacaoCartaoRequest = criarCartao.criaCartao(new AnalisePropostaRequest(
                    proposta.getDocumento(),
                    proposta.getNome(),
                    proposta.getId().toString()));

            var cartao = cartaoConverter.converter(retornoCriacaoCartaoRequest, proposta);
            proposta.insereCartaoNaProposta(cartao);
            propostaPort.salvarProposta(proposta);

        });

        logger.info("Fim do Schedule para criação do cartão para propostas elegiveis");
    }
}
