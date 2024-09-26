package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorSubindo extends EstadoElevador {

    public ElevadorSubindo(Elevador elevador) {
        super(elevador);
    }

    @Override
    public void subir() {

        elevador.setPortaAberta(false);
        int andarDestinoAtual = elevador.getAndarAtual();

        while (elevador.getAndarAtual() < elevador.getAndarDestino()) {
            // TODO - é necessário verificar se alguém chamou o elevador em um andar intermediário a cada andar que ele passa

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
