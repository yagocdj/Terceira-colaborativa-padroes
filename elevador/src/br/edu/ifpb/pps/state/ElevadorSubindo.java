package br.edu.ifpb.pps.state;

import br.edu.ifpb.pps.elevador.Elevador;

public class ElevadorSubindo extends EstadoElevador {

    public ElevadorSubindo(Elevador elevador) {
        super(elevador);
        subir();
    }

    @Override
    public void subir() {

        elevador.fecharPorta();

        // Atende as requisições na fila de subida
        while (!elevador.getFilaSubida().isEmpty()) {
            int proximoAndar = elevador.getFilaSubida().poll(); // Próxima requisição de subida
            
            while (elevador.getAndarAtual() < proximoAndar) {
                elevador.setAndarAtual(elevador.getAndarAtual() + 1);
                elevador.mostrarSituacao();
            }
            
            System.out.println("Parando para atender requisição no andar " + proximoAndar);
            elevador.setEstado(new ElevadorParado(elevador));
            elevador.abrirPorta();
            // Aqui ele atenderia o passageiro (abrir portas, etc.)
        }

        // Após atender todas as requisições de subida, verificar se há descida
        if (!elevador.getFilaDescida().isEmpty()) {
            elevador.setEstado(new ElevadorDescendo(elevador));
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
    public EstadoEnum getEstado() {
        return EstadoEnum.SUBINDO;
    }
    
}
