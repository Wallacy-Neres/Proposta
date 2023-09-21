package br.com.zup.proposta.adapters.handler;

import br.com.zup.proposta.adapters.handler.impl.PegaTipoExceptionFactoryFactoryImpl;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@Component
@ControllerAdvice
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private PegaTipoExceptionFactoryFactoryImpl pegaTipoException;

    @ExceptionHandler({Exception.class})
    public void handleException(Throwable ex) {

        pegaTipoException.getImplementacao(ex).trataException(ex);
    }
}
