package br.com.zup.proposta.adapters.webservices.cartoes.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RetornoCriacaoCartaoRequest {

    private String id;
    private LocalDateTime emitidoEm;
    private String titular;

    private BigDecimal limite;

    private BloqueioCartaoDTO bloqueiosCartao;

    private AvisosDTO avisosDTO;

    private CarteiraDTO carteiraDTO;

    private ParcelaDTO parcelaDTO;

    private RenegociacaoDTO renegociacaoDTO;

    private VencimentoCartaoDTO vencimentoCartaoDTO;

    private String idProposta;



    public String getIdProposta() {
        return idProposta;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public BloqueioCartaoDTO getBloqueiosCartao() {
        return bloqueiosCartao;
    }

    public AvisosDTO getAvisosDTO() {
        return avisosDTO;
    }

    public CarteiraDTO getCarteiraDTO() {
        return carteiraDTO;
    }

    public ParcelaDTO getParcelaDTO() {
        return parcelaDTO;
    }

    public RenegociacaoDTO getRenegociacaoDTO() {
        return renegociacaoDTO;
    }

    public VencimentoCartaoDTO getVencimentoCartaoDTO() {
        return vencimentoCartaoDTO;
    }
}
