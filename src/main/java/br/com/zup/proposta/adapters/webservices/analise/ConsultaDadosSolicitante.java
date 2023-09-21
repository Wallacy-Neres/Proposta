package br.com.zup.proposta.adapters.webservices.analise;

import br.com.zup.proposta.adapters.webservices.analise.dto.AnalisePropostaRequest;
import br.com.zup.proposta.adapters.webservices.analise.dto.ResultadoAnalise;
import br.com.zup.proposta.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "solicitacao", url = "${servico.analise.proposta}", configuration = FeignConfig.class)
public interface ConsultaDadosSolicitante {

    @RequestMapping(method = RequestMethod.POST, value = "/api/solicitacao", produces = "application/json", consumes = "application/json")
    public ResultadoAnalise solicitaAnaliseDeDados(AnalisePropostaRequest request);


}
