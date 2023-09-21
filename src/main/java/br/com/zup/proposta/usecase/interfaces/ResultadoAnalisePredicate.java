package br.com.zup.proposta.usecase.interfaces;

import br.com.zup.proposta.adapters.webservices.analise.dto.ResultadoAnalise;
import br.com.zup.proposta.enums.AnaliseEnum;

@FunctionalInterface
public interface ResultadoAnalisePredicate {
     boolean validaResultado(ResultadoAnalise resultadoAnalise);
}
