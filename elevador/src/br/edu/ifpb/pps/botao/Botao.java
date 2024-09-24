package br.edu.ifpb.pps.botao;

import br.edu.ifpb.pps.enumerations.Acao;

public class Botao {

    private Acao acao;
    private String descricao;

    public Botao(Acao acao, String descricao) {
        this.acao = acao;
        this.descricao = descricao;
    }

    public Acao getAcao() {
        return acao;
    }

    public String getDescricao() {
        return descricao;
    }
}
