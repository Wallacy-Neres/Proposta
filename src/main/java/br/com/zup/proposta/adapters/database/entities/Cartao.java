package br.com.zup.proposta.adapters.database.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CARTAO")
public class Cartao {

    @Id
    private String idCartao;
    private LocalDateTime dataCriacaoCartao;
    private String titular;

    private BigDecimal limite;

    @OneToOne
    private Proposta proposta;

    @Deprecated
    public Cartao(){}

    public Cartao(String idCartao, LocalDateTime dataCriacaoCartao, String titular, BigDecimal limite, Proposta proposta) {
        this.idCartao = idCartao;
        this.dataCriacaoCartao = dataCriacaoCartao;
        this.titular = titular;
        this.limite = limite;
        this.proposta = proposta;
    }
}
