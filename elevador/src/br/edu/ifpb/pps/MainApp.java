package br.edu.ifpb.pps;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.pps.botao.Botao;
import br.edu.ifpb.pps.comando.Comando;
import br.edu.ifpb.pps.comando.ComandoChamarAndar;
import br.edu.ifpb.pps.comando.ComandoChamarAndarDescendo;
import br.edu.ifpb.pps.comando.ComandoChamarAndarSubindo;
import br.edu.ifpb.pps.elevador.Elevador;
import br.edu.ifpb.pps.enumerations.Acao;
import br.edu.ifpb.pps.painel.PainelDeControle;

public class MainApp {
    public static void main(String[] args) throws Exception {

        // Instanciando o elevador (começa no andar 0 - térreo)
        Elevador elevador = Elevador.obterInstancia();
        elevador.setQuantidadeTotalAndares(10);

        // Instanciando o painel de controle
        PainelDeControle painelDeControle = new PainelDeControle(elevador);
        elevador.setPainelDeControle(painelDeControle);

        List<Botao> botoesAndaresDescer = new ArrayList<>();
        List<Botao> botoesAndaresSubir = new ArrayList<>();

        for (int i = 0; i <= elevador.getQuantidadeTotalAndares(); i++) {
            Botao botaoSubir = new Botao(Acao.SUBIR.toString() + i);
            Botao botaoDescer = new Botao(Acao.DESCER.toString() + i);

            botaoSubir.setComando(new ComandoChamarAndarSubindo(elevador, i));
            botaoDescer.setComando(new ComandoChamarAndarDescendo(elevador, i));

            botoesAndaresSubir.add(botaoSubir);
            botoesAndaresDescer.add(botaoDescer);
        }

        // Chamando o elevador para o andar 5
        painelDeControle.chamarAndar(3);
        painelDeControle.chamarAndar(5);

        botoesAndaresSubir.get(4).executarComando();
        botoesAndaresDescer.get(0).executarComando();
        
        elevador.mover();
    }
}
