package br.com.zup.proposta.dto;

import br.com.zup.proposta.adapters.validation.CPFouCNPJ;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PropostaDTO {

    @CPFouCNPJ
    @NotBlank
    private String documento;

    @NotBlank
    @NotEmpty
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;


    @NotNull
    @Positive
    private BigDecimal salario;

    public PropostaDTO(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
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


}
