package br.com.zup.proposta.adapters.webservices.cartoes;

import br.com.zup.proposta.adapters.webservices.analise.dto.AnalisePropostaRequest;
import br.com.zup.proposta.adapters.webservices.cartoes.dto.RetornoCriacaoCartaoRequest;
import br.com.zup.proposta.config.FeignCartoesConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "criaCartao", url = "${servico.cartoes}", configuration = FeignCartoesConfig.class)
public interface CriarCartao {

    @RequestMapping(method = RequestMethod.POST, value = "/api/cartoes")
    public RetornoCriacaoCartaoRequest criaCartao(AnalisePropostaRequest request);


}
