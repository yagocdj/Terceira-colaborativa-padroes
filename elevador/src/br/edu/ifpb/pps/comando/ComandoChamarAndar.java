package br.edu.ifpb.pps.comando;

import br.edu.ifpb.pps.elevador.Elevador;

public class ComandoChamarAndar implements Comando {
    
    private Elevador elevador;
    private int andar;
    
    public ComandoChamarAndar(Elevador elevador, int andar) {
        this.elevador = elevador;
        this.andar = andar;
    }

    @Override
    public void executar() {
        elevador.adicionarAndarNaFilaDeRequisicoes(andar);
    }

}
