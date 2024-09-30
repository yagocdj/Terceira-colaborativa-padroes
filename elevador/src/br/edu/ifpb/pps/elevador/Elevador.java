package br.edu.ifpb.pps.elevador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import br.edu.ifpb.pps.painel.PainelDeControle;
import br.edu.ifpb.pps.state.ElevadorDescendo;
import br.edu.ifpb.pps.state.ElevadorParado;
import br.edu.ifpb.pps.state.ElevadorSubindo;
import br.edu.ifpb.pps.state.EstadoElevador;

/**
 * Classe que representa o elevador
 */
public class Elevador {

    private int andarAtual;
    private boolean portaAberta;
    private int quantidadeTotalAndares;

    private EstadoElevador estado; // SUBINDO, DESCENDO ou PARADO

    private Queue<Integer> filaSubir;
    private Queue<Integer> filaDescer;

    private PainelDeControle painelDeControle;

    private static Elevador instancia;

    private Elevador() {
        this.andarAtual = 0; // Térreo
        this.portaAberta = true; // A porta está aberta pois o elevador está parado

        this.filaSubir = new PriorityQueue<>();
        this.filaDescer = new PriorityQueue<>((a, b) -> b - a);

        this.estado = new ElevadorParado(this);
    }

    /**
     * Método para obter uma instância única da classe Elevador
     * 
     * @return Instância única da classe Elevador
     */
    public static Elevador obterInstancia() {
        if (instancia == null) {
            instancia = new Elevador();
        }
        return instancia;
    }

    public PainelDeControle getPainelDeControle() {
        return painelDeControle;
    }

    public void setPainelDeControle(PainelDeControle painelDeControle) {
        this.painelDeControle = painelDeControle;
    }

    public void adicionarAndarNaFilaDeRequisicoes(int andar) {
        if (getAndarAtual() > andar) {
            this.filaDescer.add(andar);
        } else if (getAndarAtual() < andar) {
            this.filaSubir.add(andar);
        }
    }

    public void adicionarRequisicaoSubida(int andar) {
        filaSubir.offer(andar);
    }

    public void adicionarRequisicaoDescida(int andar) {
        filaDescer.offer(andar);
    }

    public Queue<Integer> getFilaDescida() {
        return this.filaDescer;
    }

    public Queue<Integer> getFilaSubida() {
        return this.filaSubir;
    }

    public void mover() {
        mostrarSituacao();

        if (filaSubir.isEmpty() && filaDescer.isEmpty()) {
            System.out.println("Nenhuma requisição. O elevador permanecerá parado.");
            setEstado(new ElevadorParado(this));
            return;
        }

        if (!filaSubir.isEmpty()) {
            setEstado(new ElevadorSubindo(this));
            estado.subir();
        } else if (!filaDescer.isEmpty()) {
            setEstado(new ElevadorDescendo(this));
            estado.descer();
        } else {
            setEstado(new ElevadorParado(this));
            estado.parar();
        }
    }

    public void setQuantidadeTotalAndares(int quantidadeTotalAndares) {
        this.quantidadeTotalAndares = quantidadeTotalAndares;
    }

    public int getQuantidadeTotalAndares() {
        return quantidadeTotalAndares;
    }

    public void abrirPorta() {
        this.portaAberta = true;
        System.out.println("|--- Abrindo Porta do Elevador ---|\n");
    }

    public void fecharPorta() {
        this.portaAberta = false;
        System.out.println("|--- Fechando Porta do Elevador ---|\n");
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

    public EstadoElevador getEstado() {
        return this.estado;
    }

    public void mostrarSituacao() {
        List<Integer> combinada = new ArrayList<>();
        List<Integer> descidas = new ArrayList<>(filaDescer);
        Collections.sort(descidas, Collections.reverseOrder()); // Ordena em ordem decrescente

        combinada.addAll(filaSubir);
        combinada.addAll(descidas);

        StringBuilder s = new StringBuilder();

        s.append("+-----------------+\n");
        s.append("| " + combinada + " |\n");
        s.append("+-----------------+\n");
        s.append("| " + estado.getEstadoEnum().toString() + "[" + getAndarAtual() + "]" + " |\n");
        s.append("+-----------------+\n");
        System.out.println(s);
    }

}
