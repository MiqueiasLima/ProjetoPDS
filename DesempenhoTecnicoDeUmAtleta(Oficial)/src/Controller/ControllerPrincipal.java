/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Facade;
import model.Observer;
import view.CadastrarPartida;
import view.ViewCadastrarDesempenho;
import view.ViewCadastrarJogador;
import view.ViewCadastroTime;
import view.ViewGerarRelatorio;
import view.ViewPrincipal;

/**
 *
 * @author Miqueias
 */
public class ControllerPrincipal implements Observer {

    private Facade modelo;
    private ViewPrincipal viewP;

   

    public ControllerPrincipal(Facade modelo, ViewPrincipal viewP) {
        this.modelo = modelo;
        this.viewP = viewP;
        this.modelo.attach(this);
    }

    public void trataEvento(java.awt.event.ActionEvent evt) {

        if ("Cadastrar Time".equals(evt.getActionCommand())) {

            ViewCadastroTime viewCadastroTime = new ViewCadastroTime(modelo);

            viewCadastroTime.setDefaultCloseOperation(ViewCadastroTime.DO_NOTHING_ON_CLOSE);
            viewCadastroTime.setTitle("Cadastrar Time");
            viewCadastroTime.setVisible(true);

        }

        if ("Cadastrar Desempenho".equals(evt.getActionCommand())) {
            ViewCadastrarDesempenho v1 = new ViewCadastrarDesempenho(modelo);
            v1.setDefaultCloseOperation(ViewCadastrarDesempenho.DO_NOTHING_ON_CLOSE);
            v1.setTitle("Cadastrar Desempenho");
            v1.setVisible(true);

        }

        if ("Cadastrar Partida".equals(evt.getActionCommand())) {
            CadastrarPartida cp = new CadastrarPartida(modelo);
            cp.setDefaultCloseOperation(CadastrarPartida.DO_NOTHING_ON_CLOSE);
            cp.setTitle("Cadastrar Partida");
            cp.setVisible(true);

        }
        if("Inserir Jogador".equals(evt.getActionCommand())){
              ViewCadastrarJogador vCj = new ViewCadastrarJogador(modelo);
              vCj.setDefaultCloseOperation(ViewCadastrarJogador.DO_NOTHING_ON_CLOSE);
              
              vCj.setTitle("Cadastrar Jogador");
              vCj.setVisible(true);
        }
        if ("Gerar Relatório".equals(evt.getActionCommand())) {
            
            ViewGerarRelatorio view = new ViewGerarRelatorio(modelo);
            view.setDefaultCloseOperation(ViewGerarRelatorio.DO_NOTHING_ON_CLOSE);
            view.setTitle("Gerar Relatório");
            view.setVisible(true);
        }

    }

    @Override
    public void update() {

    }

}
