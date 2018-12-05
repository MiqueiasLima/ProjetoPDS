/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.MouseEvent;
import model.Desempenho;
import model.Facade;
import model.Jogador;
import model.Observer;
import view.ViewCadastrarDesempenho;
import model.Partida;

/**
 *
 * @author Miqueias
 */
public class ControllerCadastroDesempenho implements Observer {

    private Facade modelo;
    private ViewCadastrarDesempenho viewCdastroDesempenho;
    private int id;

    public ControllerCadastroDesempenho(Facade modelo, ViewCadastrarDesempenho viewCdastroDesempenho) {
        this.modelo = modelo;
        this.viewCdastroDesempenho = viewCdastroDesempenho;
        this.modelo.attach(this);
    }

    public void trataEvento(java.awt.event.ActionEvent evt) {

        if ("Cadastrar Desempenho".equals(evt.getActionCommand())) {
            Partida partida = (Partida) this.viewCdastroDesempenho.getjComboPartida1().getSelectedItem();
            Jogador jogador = (Jogador) this.viewCdastroDesempenho.getjComboJogador1().getSelectedItem();
            
            this.modelo.cadastrarDesempenho(Integer.parseInt(this.viewCdastroDesempenho.getjPassesCertos().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjPassesE().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjFinalizacoesGols().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDominioTotal().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDominioCerto().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDominioErrado().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDesarme().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjGols().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjAssistencia().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDrible().getText()), jogador, partida);
        }
        if ("Alterar".equals(evt.getActionCommand())) {
            Partida partida = (Partida) this.viewCdastroDesempenho.getjComboPartida1().getSelectedItem();
            Jogador jogador = (Jogador) this.viewCdastroDesempenho.getjComboJogador1().getSelectedItem();
            this.modelo.atualizarDesempenho(this.id, Integer.parseInt(this.viewCdastroDesempenho.getjPassesCertos().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjPassesE().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjFinalizacoesGols().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDominioTotal().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDominioCerto().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDominioErrado().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDesarme().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjGols().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjAssistencia().getText()), Integer.parseInt(this.viewCdastroDesempenho.getjDrible().getText()), jogador, partida);

        }

        if ("Excluir".equals(evt.getActionCommand())) {

            this.modelo.excluirDesempenho(id);

        }
        if (evt.getActionCommand() == "Cancelar") {
            this.viewCdastroDesempenho.dispose();
        }
       

        if ("comboBoxChanged".equals(evt.getActionCommand())) {
            Partida partida = (Partida) this.viewCdastroDesempenho.getjComboPartida1().getSelectedItem();
            this.modelo.getPartida().setId(partida.getId());
            this.viewCdastroDesempenho.atualizarList();

        }
    }

    @Override
    public void update() {

    }

    public void trataEvento(MouseEvent evt) {

        Desempenho desempenho = (Desempenho) (Object) this.viewCdastroDesempenho.getJLista().getSelectedValue();
        this.id = desempenho.getId();

        this.viewCdastroDesempenho.getjAssistencia().setText(desempenho.getAssistencia() + "");
        this.viewCdastroDesempenho.getjDesarme().setText(desempenho.getDesarme() + "");
        this.viewCdastroDesempenho.getjDominioCerto().setText(desempenho.getDominioCerto() + "");
        this.viewCdastroDesempenho.getjDominioErrado().setText(desempenho.getDominioErrado() + "");
        this.viewCdastroDesempenho.getjDominioTotal().setText(desempenho.getDominioTotal() + "");
        this.viewCdastroDesempenho.getjDrible().setText(desempenho.getDrible() + "");
        this.viewCdastroDesempenho.getjFinalizacoesGols().setText(desempenho.getFinalizacoesGols() + "");
        this.viewCdastroDesempenho.getjFinalizacoesTotais().setText(desempenho.getFinalizacoesTotais() + "");
        this.viewCdastroDesempenho.getjGols().setText(desempenho.getGol() + "");
        this.viewCdastroDesempenho.getjPassesCertos().setText(desempenho.getPassesCertos() + "");
        this.viewCdastroDesempenho.getjPassesE().setText(desempenho.getPassesErrados() + "");

        this.viewCdastroDesempenho.getjPassesTotais().setText((desempenho.getPassesCertos() + desempenho.getPassesErrados()) + "");

        Jogador jogador = this.modelo.BuscarJogadorPeloId(desempenho.getJogador().getId());

        this.viewCdastroDesempenho.getjComboJogador1().setSelectedItem(jogador);

    }

}
