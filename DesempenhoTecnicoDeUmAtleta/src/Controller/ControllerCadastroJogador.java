/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Facade;
import model.Observer;
import view.ViewCadastrarDesempenho;
import view.ViewCadastrarJogador;

/**
 *
 * @author Miqueias
 */
public class ControllerCadastroJogador implements Observer {
    
    private Facade modelo;
    private ViewCadastrarJogador viewCdastroJogador;
    
    public ControllerCadastroJogador(Facade modelo, ViewCadastrarJogador viewCdastroJogador){
        this.modelo = modelo;
        this.viewCdastroJogador = viewCdastroJogador;
        this.modelo.attach(this);
    }

    public void trataEvt(java.awt.event.ActionEvent evt){
        if(evt.getActionCommand() == "Fechar"){
            this.viewCdastroJogador.dispose();
        }
    }
    @Override
    public void update() {
        
    }
}
