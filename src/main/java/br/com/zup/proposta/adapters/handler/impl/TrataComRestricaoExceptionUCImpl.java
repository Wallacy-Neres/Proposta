package br.com.zup.proposta.adapters.handler.impl;

import br.com.zup.proposta.adapters.database.converter.PropostaConverter;
import br.com.zup.proposta.adapters.handler.interfaces.TrataExceptionUC;
import br.com.zup.proposta.dto.PropostaDTO;
import br.com.zup.proposta.enums.StatusProposta;
import br.com.zup.proposta.exception.RestricaoException;
import br.com.zup.proposta.port.interfaces.PropostaPort;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrataComRestricaoExceptionUCImpl implements TrataExceptionUC {

    @Autowired
    private PropostaPort propostaPort;

    @Autowired
    private PropostaConverter converter;

    @Override
    public boolean validaException(Throwable exception) {
        return exception instanceof RestricaoException;
    }

    @Override
    public void trataException(Throwable exception) {

        RestricaoException restricaoException = (RestricaoException) exception;

        final Response response = restricaoException.getRequest();

        final byte[] body = response.request().body();
        var propostaDTO = converter.converterBytesToPropostaDTO(body);

        propostaPort.atualizaProposta(StatusProposta.NAO_ELEGIVEL, propostaDTO.getDocumento());

    }
}
