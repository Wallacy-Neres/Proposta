package br.com.zup.proposta.enums;

public enum StatusProposta {

    NAO_ELEGIVEL("NAO_ELEGIVEL"),
    ELEGIVEL("ELEGIVEL");

    private String descricao;
    StatusProposta(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
