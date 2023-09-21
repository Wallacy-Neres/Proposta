package br.com.zup.proposta.dto;

import br.com.zup.proposta.adapters.database.entities.Proposta;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartaoDTO {


    private String idCartao;
    private LocalDateTime dataCriacaoCartao;
    private String titular;

    private BigDecimal limiteDTO;

    @NotBlank
    private Proposta proposta;
}
