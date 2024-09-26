package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public abstract class EstadoElevador {

    // Referência para o contexto
    protected Elevador elevador;


    public EstadoElevador(Elevador elevador) {
        this.elevador = elevador;
    }


    public abstract EstadoEnum getEstado();
    public abstract void subir();
    public abstract void descer();
    public abstract void parar();

}
