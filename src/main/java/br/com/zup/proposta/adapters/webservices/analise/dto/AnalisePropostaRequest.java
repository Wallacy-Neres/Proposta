package br.com.zup.proposta.adapters.webservices.analise.dto;

import org.springframework.boot.jackson.JsonComponent;

public class AnalisePropostaRequest {

    private String documento;
    private String nome;
    private String idProposta;

    @Deprecated
    public AnalisePropostaRequest(){

    }

    public AnalisePropostaRequest(String documento, String nome, String idProposta){
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
