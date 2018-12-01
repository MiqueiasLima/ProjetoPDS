/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Desempenho;
import model.Facade;
import model.Observer;
import view.ViewCadastrarDesempenho;

/**
 *
 * @author Miqueias
 */
public class ControllerCadastroDesempenho implements Observer {
    
    private Facade modelo;
    private ViewCadastrarDesempenho viewCdastroDesempenho;
    
    public ControllerCadastroDesempenho(Facade modelo, ViewCadastrarDesempenho viewCdastroDesempenho){
        this.modelo = modelo;
        this.viewCdastroDesempenho = viewCdastroDesempenho;
        this.modelo.attach(this);
    }
    
    
    public void trataEvento(java.awt.event.ActionEvent evt){
            
        if("Cadastrar Desempenho".equals(this.viewCdastroDesempenho.getBtnCadastrarDesempenho().getActionCommand())){
           // this.modelo.alterarDesempenho(this.viewCdastroDesempenho.getjNome().getText());
        }
        if(evt.getActionCommand() == "Cancelar"){
            this.viewCdastroDesempenho.dispose();
        }
    }
    
    @Override
    public void update() {
        
    }
    
}
