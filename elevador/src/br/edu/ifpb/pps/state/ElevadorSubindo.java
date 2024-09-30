package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorSubindo extends EstadoElevador {

    public ElevadorSubindo(Elevador elevador) {
        super(elevador);
    }

    @Override
    public void subir() {
        elevador.fecharPorta();

        while (!elevador.getFilaSubida().isEmpty()) {
            int proximoAndar = elevador.getFilaSubida().poll();

            while (elevador.getAndarAtual() < proximoAndar) {
                try {
                    elevador.setAndarAtual(elevador.getAndarAtual() + 1);
                    elevador.mostrarSituacao();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("|--- Parando para atender requisição no " + proximoAndar + "° andar ---|\n");
            elevador.setEstado(new ElevadorParado(elevador));
            elevador.getEstado().parar();
        }

        // Após atender todas as requisições de subida, verificar se há descida
        if (!elevador.getFilaDescida().isEmpty()) {
            elevador.setEstado(new ElevadorDescendo(elevador));
            elevador.getEstado().descer();
        }
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
    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.SUBINDO;
    }

}
