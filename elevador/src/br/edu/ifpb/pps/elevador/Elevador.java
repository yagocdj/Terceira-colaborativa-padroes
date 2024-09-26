package br.edu.ifpb.pps.elevador;

import java.util.LinkedList;
import java.util.Queue;

import br.edu.ifpb.pps.painel.PainelDeControle;
import br.edu.ifpb.pps.state.ElevadorDescendo;
import br.edu.ifpb.pps.state.ElevadorParado;
import br.edu.ifpb.pps.state.ElevadorSubindo;
import br.edu.ifpb.pps.state.EstadoElevador;
import br.edu.ifpb.pps.state.EstadoEnum;

/**
 * Classe que representa o elevador
 */
public class Elevador {

    private int andarAtual;
    private boolean portaAberta;
    private int quantidadeTotalAndares;
    
    private EstadoElevador estado;  // SUBINDO, DESCENDO ou PARADO
    private Queue<Integer> filaRequisicoes;
    private PainelDeControle painelDeControle;

    private static Elevador instancia;

    private Elevador() {
        this.andarAtual = 0;
        this.quantidadeTotalAndares = 9;
        this.portaAberta = true;
        this.estado = new ElevadorParado(this);

        this.painelDeControle = new PainelDeControle(this);
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

    public PainelDeControle getPainelDeControle(){
        return painelDeControle;
    }
    
    public void adicionarAndarNaFilaDeRequisicoes(int andar){
        filaRequisicoes.add(andar);
    }

    public void mover(){
        System.out.println(filaRequisicoes);
        if (filaRequisicoes.isEmpty()){
            return;
        }

        int proximoAndar = filaRequisicoes.peek();

        if (getAndarAtual() < proximoAndar) {
            setEstado(new ElevadorSubindo(this));
        } 
        else if (getAndarAtual() > proximoAndar) {
            setEstado(new ElevadorDescendo(this));
        } 
        else {
            setEstado(new ElevadorParado(this));
            filaRequisicoes.poll();
        }
    }

    public int getAndarDestino(){
        return filaRequisicoes.peek();
    }

    public void setQuantidadeTotalAndares(int quantidadeTotalAndares) {
        this.quantidadeTotalAndares = quantidadeTotalAndares;
    }

    public int getQuantidadeTotalAndares() {
        return quantidadeTotalAndares;
    }

    public void abrirPorta() {
        this.portaAberta = true;
    }

    public void fecharPorta() {
        this.portaAberta = false;
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

    public void setEstado(EstadoElevador estado) {
        this.estado = estado;
    }

    public EstadoEnum getEstado() {
        return estado.getEstado();
    }
}
