/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Facade;
import model.Observer;
import view.CadastrarPartida;
import view.ViewCadastroTime;

/**
 *
 * @author Miqueias
 */
public class ControllerPartida implements Observer{

    private Facade modelo;
    private CadastrarPartida cadastrarPartida;
    
    public ControllerPartida(Facade modelo, CadastrarPartida cadastrarPartida){
        this.modelo = modelo;
        this.cadastrarPartida = cadastrarPartida;
        
        this.modelo.attach(this);
    
    }
    
    
    @Override
    public void update() {
       
    }
    
}
