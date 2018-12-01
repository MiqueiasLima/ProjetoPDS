/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JDialog;
import model.Facade;
import model.Observer;
import view.CadastrarPartida;
import view.ViewCadastrarDesempenho;
import view.ViewCadastroTime;
import view.ViewPrincipal;

/**
 *
 * @author Miqueias
 */
public class ControllerPrincipal implements Observer {
    
    Facade modelo;
    ViewPrincipal viewP;
    ViewCadastroTime viewCadastroTime; 
    CadastrarPartida cp;
  
    
    public ControllerPrincipal(Facade modelo, ViewPrincipal viewP){
        this.modelo = modelo;
        this.viewP = viewP;
        this.modelo.attach(this);
    }
    
    public void trataEvento(java.awt.event.ActionEvent evt){
            
        if("Cadastrar Time".equals(evt.getActionCommand())){
            
           ViewCadastroTime viewCadastroTime = new ViewCadastroTime(modelo);
            viewCadastroTime.setDefaultCloseOperation(ViewCadastroTime.DO_NOTHING_ON_CLOSE);
            viewCadastroTime.setTitle("Cadastrar Time");
            viewCadastroTime.setVisible(true);
            
            
        }
        
        if("Cadastrar Desempenho".equals(evt.getActionCommand())){
            ViewCadastrarDesempenho v1 = new ViewCadastrarDesempenho(modelo);           
            v1.setDefaultCloseOperation(ViewCadastrarDesempenho.DO_NOTHING_ON_CLOSE);
            v1.setTitle("Cadastrar Desempenho");
            v1.setVisible(true);
            
        }
        
        if("Cadastrar Partida".equals(evt.getActionCommand())){
         CadastrarPartida cp = new CadastrarPartida(modelo);
         cp.setDefaultCloseOperation(CadastrarPartida.DO_NOTHING_ON_CLOSE);
         cp.setTitle("Cadastrar Partida");
         cp.setVisible(true);
            
        }
        
    }
    
    
    
    
    @Override
    public void update() {
       
    }
    
}
