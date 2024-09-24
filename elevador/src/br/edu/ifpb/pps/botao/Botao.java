package br.edu.ifpb.pps.botao;

import br.edu.ifpb.pps.enumerations.Acao;

/**
 * Classe que representa um botão de um elevador.
 * Esse botão pode estar dentro do elevador ou em um andar.
 */
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
