/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Facade;
import model.Observer;
import view.ViewCadastrarJogador;
import view.ViewCadastroTime;
import view.ViewPrincipal;

/**
 *
 * @author Miqueias
 */
public class ControllerCadastroTime implements Observer {
    Facade modelo;
    ViewCadastroTime viewCdastroTime;
    ViewPrincipal viewPrincipal;
    
    
    ViewCadastroTime vCd = new ViewCadastroTime(modelo);
    
    public ControllerCadastroTime(Facade modelo, ViewCadastroTime viewCdastroTime){
        this.modelo = modelo;
        this.viewCdastroTime = viewCdastroTime;
        this.modelo.attach(this);
    }

    public void trataEvtn(java.awt.event.ActionEvent evt){
        if("Inserir Jogador".equals(evt.getActionCommand())){
            
        }
    }
    
    @Override
    public void update() {
        
    }
}