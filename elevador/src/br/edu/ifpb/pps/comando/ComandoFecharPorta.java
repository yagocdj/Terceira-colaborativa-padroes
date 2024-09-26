package br.edu.ifpb.pps.comando;

import br.edu.ifpb.pps.elevador.Elevador;
import br.edu.ifpb.pps.state.EstadoEnum;

public class ComandoFecharPorta implements Comando {

    private Elevador elevador;
    
    public ComandoFecharPorta(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void executar() {
        if (elevador.getEstado() == EstadoEnum.PARADO) {
            elevador.fecharPorta();
        }
    }

}
