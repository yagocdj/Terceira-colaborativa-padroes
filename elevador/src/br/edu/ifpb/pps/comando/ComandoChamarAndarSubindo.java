package br.edu.ifpb.pps.comando;

import br.edu.ifpb.pps.elevador.Elevador;

public class ComandoChamarAndarSubindo implements Comando {

    private Elevador elevador;
    private int andarDoBotao;

    public ComandoChamarAndarSubindo(Elevador elevador, int andarDoBotao) {
        this.elevador = elevador;
        this.andarDoBotao = andarDoBotao;
    }

    @Override
    public void executar() {
        elevador.adicionarRequisicaoSubida(andarDoBotao);
    }

}
