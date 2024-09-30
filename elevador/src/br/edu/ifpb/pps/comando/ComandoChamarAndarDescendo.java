package br.edu.ifpb.pps.comando;

import br.edu.ifpb.pps.elevador.Elevador;

public class ComandoChamarAndarDescendo implements Comando {

    private Elevador elevador;
    private int andarDoBotao;

    public ComandoChamarAndarDescendo(Elevador elevador, int andarDoBotao) {
        this.elevador = elevador;
        this.andarDoBotao = andarDoBotao;
    }

    @Override
    public void executar() {
        elevador.adicionarRequisicaoDescida(andarDoBotao);
    }

}
