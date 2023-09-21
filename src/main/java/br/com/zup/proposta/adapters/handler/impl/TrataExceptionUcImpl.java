package br.com.zup.proposta.adapters.handler.impl;

import br.com.zup.proposta.adapters.handler.interfaces.TrataExceptionUC;
import feign.Response;
import org.springframework.stereotype.Component;

@Component
public class TrataExceptionUcImpl implements TrataExceptionUC {


    @Override
    public boolean validaException(Throwable exception) {
        return false;
    }

    @Override
    public void trataException(Throwable exception) {

        System.out.println("Caiu aqui");
    }
}
