package br.edu.ifpb.pps.botao;

import br.edu.ifpb.pps.comando.Comando;
import br.edu.ifpb.pps.enumerations.Acao;

/**
 * Classe que representa um botão de um elevador.
 * Esse botão pode estar dentro do elevador ou em um andar.
 */
public class Botao {

    // private Acao acao;
    private Comando comando;
    private String descricao;

    // public Botao(Acao acao, String descricao) {
    //     this.acao = acao;
    //     this.descricao = descricao;
    // }

    public Botao(String descricao) {
        this.descricao = descricao;
    }

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void executarComando() {
        comando.executar();
    }

    // public Acao getAcao() {
    //     return acao;
    // }

    public String getDescricao() {
        return descricao;
    }
}
