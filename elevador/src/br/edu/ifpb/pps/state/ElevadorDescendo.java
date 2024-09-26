package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorDescendo extends EstadoElevador {
    
    public ElevadorDescendo(Elevador elevador){
        super(elevador);
    }

    @Override
    public void subir(){};

    @Override
    public void descer(){};

    @Override
    public void parar(){}

    @Override
    public EstadoEnum getEstado() {
        return EstadoEnum.DESCENDO;
    };
}
