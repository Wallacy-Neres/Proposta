package br.com.zup.proposta.adapters.handler.interfaces;

import feign.Response;

public interface PegaTipoExceptionFactory {
    TrataExceptionUC getImplementacao(Throwable exception);
}
