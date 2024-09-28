package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorDescendo extends EstadoElevador {

    public ElevadorDescendo(Elevador elevador) {
        super(elevador);
        System.out.println("!!! Elevador Descendo !!!");
        descer();
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
                elevador.setAndarAtual(elevador.getAndarAtual() - 1);
                elevador.mostrarSituacao();
            }
            
            System.out.println("Parando para atender requisição no andar " + proximoAndar);
            elevador.setEstado(new ElevadorParado(elevador));
            elevador.abrirPorta();
            // Aqui ele atenderia o passageiro (abrir portas, etc.)
        }

        // Após atender todas as requisições de descida, verificar se há subida
        if (!elevador.getFilaSubida().isEmpty()) {
            elevador.setEstado(new ElevadorSubindo(elevador));
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
