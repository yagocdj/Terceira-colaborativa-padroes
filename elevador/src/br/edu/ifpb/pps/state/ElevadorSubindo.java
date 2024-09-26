package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorSubindo extends EstadoElevador {

    public ElevadorSubindo(Elevador elevador) {
        super(elevador);
        System.out.println("!!! Elevador Subindo !!!");
        subir();
    }

    @Override
    public void subir() {

        elevador.fecharPorta();

        while (elevador.getAndarAtual() < elevador.getAndarDestino()) {
            // considerando que o elevador está no 0, foi chamado no 8 e depois no 5.

            // Se o elevador chegar num andar de destino
            // Ele vai pro Estado Parado
            // Abre a porta
            // E dentro do Estado parado ele verifica se ainda tem requisiçoes
            // Se tiver, ele vai ter que decidir se continua subindo ou desce

            elevador.setAndarAtual(elevador.getAndarAtual() + 1);
            System.out.println("Subindo para o andar " + elevador.getAndarAtual());
        }
        elevador.setEstado(new ElevadorParado(elevador));
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
        return EstadoEnum.SUBINDO;
    }
    
}
