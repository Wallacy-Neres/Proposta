package br.com.zup.proposta.config;

import br.com.zup.proposta.exception.RestricaoException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class FeignErrorDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Exception decode(String chaveMetodo, Response response) {

        switch (response.status()){
            case 400:
                logger.error("Erro ao consultar" + response.status());

            case 422:
               return  new RestricaoException("Cliente com restrição", response) ;

            default:
                return errorDecoder.decode(chaveMetodo, response);
        }
    }
}
