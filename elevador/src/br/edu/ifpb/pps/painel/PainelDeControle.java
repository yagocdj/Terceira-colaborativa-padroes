package br.edu.ifpb.pps.painel;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.pps.botao.Botao;
import br.edu.ifpb.pps.comando.Comando;
import br.edu.ifpb.pps.comando.ComandoAbrirPorta;
import br.edu.ifpb.pps.comando.ComandoChamarAndar;
import br.edu.ifpb.pps.comando.ComandoFecharPorta;
import br.edu.ifpb.pps.elevador.Elevador;
import br.edu.ifpb.pps.enumerations.Acao;

/**
 * Classe que representa o painel de controle do elevador, contendo os botões e o display.
 */
public class PainelDeControle {

    private final Botao botaoAbrirPorta;
    private final Botao botaoFecharPorta;
    private final List<Botao> botoesAndares;

    public PainelDeControle(Elevador elevador) {
        // criando o botão para abrir a porta
        this.botaoAbrirPorta = new Botao(Acao.ABRIR_PORTA.toString());
        this.botaoAbrirPorta.setComando(new ComandoAbrirPorta(elevador));

        // criando o botão para fechar a porta
        this.botaoFecharPorta = new Botao(Acao.FECHAR_PORTA.toString());
        this.botaoFecharPorta.setComando(new ComandoFecharPorta(elevador));

        this.botoesAndares = new ArrayList<>();
    
        // criar os botões para cada andar
        for (int i = 0; i <= elevador.getQuantidadeTotalAndares(); i++) {
            Comando chamarAndar = new ComandoChamarAndar(elevador, i);
            Botao botao = new Botao(Acao.SELECIONAR_ANDAR.toString() + i);
            botao.setComando(chamarAndar);

            this.botoesAndares.add(botao);
        }
    }

    public void chamarAndar(int andar) {
        botoesAndares.get(andar).executarComando();
    }

    public void pressionarBotaoAbrirPorta() {
        botaoAbrirPorta.executarComando();
    }

    public void pressionarBotaoFecharPorta() {
        botaoFecharPorta.executarComando();
    }

}
