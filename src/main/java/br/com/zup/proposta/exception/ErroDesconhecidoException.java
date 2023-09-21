package br.com.zup.proposta.exception;

import feign.Response;

public class ErroDesconhecidoException extends Exception {
    public ErroDesconhecidoException(String mensagem) {
        super(mensagem);
    }
}
