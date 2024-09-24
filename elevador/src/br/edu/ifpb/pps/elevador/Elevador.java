package br.edu.ifpb.pps.elevador;

public class Elevador {

    private Integer andarAtual;
    private Boolean portaAberta;
    private static Elevador instancia;

    private Elevador() {
        this.andarAtual = 0;
        this.portaAberta = true;
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

}
