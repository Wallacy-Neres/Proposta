package br.com.zup.proposta.enums;

public enum AnaliseEnum {

    COM_RESTRICAO("COM_RESTRICAO"),
    SEM_RESTRICAO("SEM_RESTRICAO");

    private String descricao;

    AnaliseEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
