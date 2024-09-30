package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorParado extends EstadoElevador {

    public ElevadorParado(Elevador elevador) {
        super(elevador);
    }

    @Override
    public void subir() {
        return;
    }

    @Override
    public void descer() {
        return;
    }

    @Override
    public void parar() {
        elevador.abrirPorta();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!elevador.getFilaSubida().isEmpty()) {
            elevador.setEstado(new ElevadorSubindo(elevador));        
        } else if (!elevador.getFilaDescida().isEmpty()) {
            elevador.setEstado(new ElevadorDescendo(elevador));
        } else {
            elevador.mostrarSituacao();
        }
    }

    @Override
    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.PARADO;
    }

}
