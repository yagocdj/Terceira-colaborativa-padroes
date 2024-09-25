package br.edu.ifpb.pps.elevador;

import java.util.LinkedList;
import java.util.Queue;

import br.edu.ifpb.pps.painel.PainelDeControle;

/**
 * Classe que representa o elevador
 */
public class Elevador {

    private int andarAtual;
    private boolean portaAberta;
    private int quantidadeTotalAndares;
    private Queue<Integer> filaRequisicoes;
    
    private PainelDeControle painelDeControle;

    private static Elevador instancia;

    private Elevador() {
        this.andarAtual = 0;
        this.portaAberta = true;
        // não faz sentido um elevador sem um painel de controle instanciado
        this.painelDeControle = new PainelDeControle();
        this.filaRequisicoes = new LinkedList<>();
    }

    /**
     * Método para obter uma instância única da classe Elevador
     * @return Instância única da classe Elevador
     */
    public static Elevador obterInstancia() {
        if (instancia == null) {
            instancia = new Elevador();
        }
        return instancia;
    }

    public void setQuantidadeTotalAndares(int quantidadeTotalAndares) {
        this.quantidadeTotalAndares = quantidadeTotalAndares;
    }

    public int getQuantidadeTotalAndares() {
        return quantidadeTotalAndares;
    }

    public void setPortaAberta(boolean portaAberta) {
        this.portaAberta = portaAberta;
    }

    public boolean isPortaAberta() {
        return portaAberta;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

}
