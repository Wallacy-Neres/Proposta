package br.com.zup.proposta.exception;

import feign.Response;


public class RestricaoException extends RuntimeException{

    private Response response;

    public RestricaoException(String message, Response response){
        super(message);
        this.response = response;
    }

    public Response getRequest() {
        return response;
    }
}
