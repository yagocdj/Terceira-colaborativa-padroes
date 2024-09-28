package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorParado extends EstadoElevador {

    public ElevadorParado(Elevador elevador) {
        super(elevador);
        System.out.println("!!! Elevador Parado !!!");
        parar();
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

        if (!elevador.getFilaSubida().isEmpty()) {
            elevador.setEstado(new ElevadorSubindo(elevador));
        } else if (!elevador.getFilaDescida().isEmpty()) {
            elevador.setEstado(new ElevadorDescendo(elevador));
        } else {
            System.out.println("Nenhuma requisição pendente.");
        }
    }

    @Override
    public EstadoEnum getEstado() {
        return EstadoEnum.PARADO;
    }

}
