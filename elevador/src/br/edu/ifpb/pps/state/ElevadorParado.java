package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorParado extends EstadoElevador {

    public ElevadorParado(Elevador elevador) {
        super(elevador);
        System.out.println("!!! Elevador Parado !!!");
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
        return;
    }

    @Override
    public EstadoEnum getEstado() {
        return EstadoEnum.PARADO;
    }

}
