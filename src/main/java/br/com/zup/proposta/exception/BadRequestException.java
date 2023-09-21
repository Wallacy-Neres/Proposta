package br.com.zup.proposta.exception;

public class BadRequestException extends Exception {
    public BadRequestException(String mensagem) {
        super(mensagem);
    }
}
