package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorDescendo extends EstadoElevador {

    public ElevadorDescendo(Elevador elevador) {
        super(elevador);
    }

    @Override
    public void subir() {
        return;
    };

    @Override
    public void descer() {
        elevador.fecharPorta();

        // Atende as requisições na fila de descida
        while (!elevador.getFilaDescida().isEmpty()) {
            int proximoAndar = elevador.getFilaDescida().poll(); // Próxima requisição de descida
            
            while (elevador.getAndarAtual() > proximoAndar) {
                try {
                    elevador.setAndarAtual(elevador.getAndarAtual() - 1);
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

        // Após atender todas as requisições de descida, verificar se há subida
        if (!elevador.getFilaSubida().isEmpty()) {
            elevador.setEstado(new ElevadorSubindo(elevador));
            elevador.getEstado().subir();
        } 
    };

    @Override
    public void parar() {
        return;
    }

    @Override
    public EstadoEnum getEstado() {
        return EstadoEnum.DESCENDO;
    };
}
