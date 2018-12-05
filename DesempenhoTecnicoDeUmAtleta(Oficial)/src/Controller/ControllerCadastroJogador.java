/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.MouseEvent;
import model.Facade;
import model.Jogador;
import model.Observer;
import model.Time;
import view.ViewCadastrarDesempenho;
import view.ViewCadastrarJogador;

/**
 *
 * @author Miqueias
 */
public class ControllerCadastroJogador implements Observer {

   private Facade modelo;
    private ViewCadastrarJogador viewCdastroJogador;
    private int id;

    public ControllerCadastroJogador(Facade modelo, ViewCadastrarJogador viewCdastroJogador) {
        this.modelo = modelo;
        this.viewCdastroJogador = viewCdastroJogador;
        this.modelo.attach(this);
    }

    public void trataEvt(java.awt.event.ActionEvent evt) {
        if (evt.getActionCommand() == "Fechar") {
            this.viewCdastroJogador.dispose();
        }

        if (evt.getActionCommand().equals("Cadastrar")) {

            Time time = (Time) this.viewCdastroJogador.getJcombo().getSelectedItem();

            this.modelo.cadastrarJogador(this.viewCdastroJogador.getTxtNome().getText(), this.viewCdastroJogador.getTxtDataNascimento().getText(), this.viewCdastroJogador.getTxt_Posicao().getText(), ((String) this.viewCdastroJogador.getjMelhorPe().getSelectedItem()).charAt(0), time);

        }

        if (evt.getActionCommand().equals("Alterar")) {

            Time time = (Time) this.viewCdastroJogador.getJcombo().getSelectedItem();

            this.modelo.atualizarJogador(id, this.viewCdastroJogador.getTxtNome().getText(), this.viewCdastroJogador.getTxtDataNascimento().getText(), this.viewCdastroJogador.getTxt_Posicao().getText(), ((String) this.viewCdastroJogador.getjMelhorPe().getSelectedItem()).charAt(0), time);

        }

        if (evt.getActionCommand().equals("Excluir")) {
            this.modelo.excluirJogador(id);

        }
    }

    @Override
    public void update() {

    }

    public void trataEvento(MouseEvent evt) {
        Jogador jogador = (Jogador) (Object) this.viewCdastroJogador.getjLista().getSelectedValue();
        this.id = jogador.getId();
        this.viewCdastroJogador.getTxtNome().setText(jogador.getNome());
        this.viewCdastroJogador.getTxtDataNascimento().setText(jogador.getDataDeNascimento());
        this.viewCdastroJogador.getTxt_Posicao().setText(jogador.getPosicao());
        this.viewCdastroJogador.getjMelhorPe().setSelectedItem(jogador.getMelhor_pe());
        if (jogador.getMelhor_pe() == 'D') {
            this.viewCdastroJogador.getjMelhorPe().setSelectedIndex(0);
        } else {

            this.viewCdastroJogador.getjMelhorPe().setSelectedIndex(1);
        }

    }
}
