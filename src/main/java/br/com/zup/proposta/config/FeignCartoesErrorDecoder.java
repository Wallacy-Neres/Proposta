package br.com.zup.proposta.config;

import br.com.zup.proposta.exception.BadRequestException;
import br.com.zup.proposta.exception.ErroDesconhecidoException;
import br.com.zup.proposta.exception.RestricaoException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class FeignCartoesErrorDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Exception decode(String chaveMetodo, Response response) {

        switch (response.status()){
            case 400:
                return  new BadRequestException("Erro ao tentar criar cartao, verifique os campos enviados");

            case 500:
               return  new ErroDesconhecidoException("O servidor não conseguiu processar, erro desconhecido");

            default:
                return errorDecoder.decode(chaveMetodo, response);
        }
    }
}
