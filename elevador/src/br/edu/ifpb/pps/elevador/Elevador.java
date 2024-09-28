package br.edu.ifpb.pps.elevador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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
        }
        else if (getAndarAtual() < andar) {
            this.filaSubir.add(andar);
        }
    }

    public void adicionarRequisicaoSubida(int andar) {
        filaSubir.offer(andar);
    }

    public void adicionarRequisicaoDescida(int andar) {
        filaDescer.offer(andar);
    }

    // Método para selecionar um andar dentro do elevador
    // public void selecionarAndar(int andar) {
    //     if (andar > andarAtual) {
    //         // Se o andar está acima, adiciona à fila de subida
    //         if (!filaSubir.contains(andar)) {
    //             filaSubir.offer(andar);
    //             System.out.println("Andar " + andar + " adicionado à fila de subida.");
    //         }
    //     } else if (andar < andarAtual) {
    //         // Se o andar está abaixo, adiciona à fila de descida
    //         if (!filaDescer.contains(andar)) {
    //             filaDescer.offer(andar);
    //             System.out.println("Andar " + andar + " adicionado à fila de descida.");
    //         }
    //     }
    //     // Se o andar solicitado é o mesmo, não faz nada
    // }

    // public void mover() {
    //     System.out.println(filaRequisicoes);
    //     if (filaRequisicoes.isEmpty()) {
    //         return;
    //     }

    //     int proximoAndar = filaRequisicoes.peek();

    //     if (getAndarAtual() < proximoAndar) {
    //         setEstado(new ElevadorSubindo(this));
    //     } else if (getAndarAtual() > proximoAndar) {
    //         setEstado(new ElevadorDescendo(this));
    //     } else {
    //         setEstado(new ElevadorParado(this));
    //         filaRequisicoes.poll();
    //     }
    // }

    public Queue<Integer> getFilaDescida(){
        return this.filaDescer;
    }

    public Queue<Integer> getFilaSubida(){
        return this.filaSubir;
    }

    public void mover() {
        // Verifica se ambas as filas estão vazias
        if (filaSubir.isEmpty() && filaDescer.isEmpty()) {
            System.out.println("Nenhuma requisição. O elevador permanecerá parado.");
            return;
        }

        if (!filaSubir.isEmpty()) {
            setEstado(new ElevadorSubindo(this));
        } else if (!filaDescer.isEmpty()) {
            setEstado(new ElevadorDescendo(this));
        } else {
            setEstado(new ElevadorParado(this));
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

    public void mostrarSituacao(){
        List<Integer> combinada = new ArrayList<>();
        combinada.addAll(filaSubir);
        List<Integer> descidas = new ArrayList<>(filaDescer);
        Collections.sort(descidas, Collections.reverseOrder());  // Ordena em ordem decrescente
        combinada.addAll(descidas);

        StringBuilder s = new StringBuilder();

        s.append("+-----------------+\n");
        s.append("| " + combinada + " |\n");
        s.append("+-----------------+\n");
        s.append("| " + estado.getEstado().toString() + "[" + getAndarAtual() + "]" + " |\n");
        s.append("+-----------------+\n");
        System.out.println(s);
    }

}
