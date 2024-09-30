package br.edu.ifpb.pps.comando;

import br.edu.ifpb.pps.elevador.Elevador;
import br.edu.ifpb.pps.state.EstadoEnum;

public class ComandoAbrirPorta implements Comando {

    private Elevador elevador;
    
    public ComandoAbrirPorta(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void executar() {
        if (elevador.getEstado().getEstadoEnum() == EstadoEnum.PARADO) {
            elevador.abrirPorta();
        }
    }
    
}
