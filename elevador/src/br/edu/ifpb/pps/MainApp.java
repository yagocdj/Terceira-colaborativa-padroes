package br.edu.ifpb.pps;

import br.edu.ifpb.pps.elevador.Elevador;
import br.edu.ifpb.pps.painel.PainelDeControle;

public class MainApp {
    public static void main(String[] args) throws Exception {

        // Instanciando o elevador (começa no andar 0 - térreo)
        Elevador elevador = Elevador.obterInstancia();
        elevador.setQuantidadeTotalAndares(10);

        // Instanciando o painel de controle
        PainelDeControle painelDeControle = new PainelDeControle(elevador);
        elevador.setPainelDeControle(painelDeControle);

        // Chamando o elevador para o andar 5
        elevador.getPainelDeControle().chamarAndar(5);
        elevador.mover();
    }
}
