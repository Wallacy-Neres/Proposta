package br.com.zup.proposta.adapters.handler.impl;

import br.com.zup.proposta.adapters.handler.interfaces.PegaTipoExceptionFactory;
import br.com.zup.proposta.adapters.handler.interfaces.TrataExceptionUC;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PegaTipoExceptionFactoryFactoryImpl implements PegaTipoExceptionFactory {

    @Autowired
    private List<TrataExceptionUC> trataExceptions;


    @Override
    public TrataExceptionUC getImplementacao(Throwable exception) {
        return trataExceptions.stream().filter(
                estrategia -> estrategia.validaException(exception))
                .findFirst()
                .orElse(new TrataExceptionUcImpl());
    }
}
