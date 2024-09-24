package br.edu.ifpb.pps;

import br.edu.ifpb.pps.elevador.Elevador;

public class MainApp {
    public static void main(String[] args) throws Exception {

        // Instanciando o elevador
        Elevador elevador = Elevador.obterInstancia();

        // Configurando a quantidade total de andares do prédio
        elevador.setQuantidadeTotalAndares(10);

    }
}
