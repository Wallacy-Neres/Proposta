package br.com.zup.proposta.adapters.handler.interfaces;

import feign.Response;

import java.io.IOException;

public interface TrataExceptionUC {

    boolean validaException(Throwable exception);

    void trataException(Throwable exception);
}
