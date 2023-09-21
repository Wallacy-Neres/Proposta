package br.com.zup.proposta.adapters.database.entities;

import br.com.zup.proposta.enums.StatusProposta;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PROPOSTA")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documento;

    private String email;

    private String nome;

    private String endereco;

    private BigDecimal salario;

    @OneToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    @Enumerated(EnumType.STRING)
    private StatusProposta statusProposta;

    @Deprecated
    public Proposta() {
    }

    public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario){
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public void insereCartaoNaProposta(Cartao cartao){
        this.cartao = cartao;
    }


    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "id=" + id +
                ", documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", salario=" + salario +
                '}';
    }

    public void setStatusProposta(StatusProposta statusProposta) {
        this.statusProposta = statusProposta;
    }
}
