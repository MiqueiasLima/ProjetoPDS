/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import model.Facade;
import model.Observer;
import model.Time;
import view.ViewCadastrarJogador;
import view.ViewCadastroTime;
import view.ViewPrincipal;

/**
 *
 * @author Miqueias
 */
public class ControllerCadastroTime implements Observer {
    
    private Facade modelo;
    private ViewCadastroTime viewCdastroTime;
    private int id;
    
    
    
    
    
    public ControllerCadastroTime(Facade modelo,  ViewCadastroTime view){
        this.modelo = modelo;
        
        this.viewCdastroTime = view;
        
        this.modelo.attach(this);
    }

    
    
    @Override
    public void update() {
        
    }

    public void trataEvt(ActionEvent evt) {
        
          
        if (evt.getActionCommand().equals("Fechar")) {
            
            this.viewCdastroTime.dispose();
            
        }
        
        if (evt.getActionCommand().equals("Cadastrar")) {
          
            this.modelo.cadastrarTime(this.viewCdastroTime.getTxtNomeTime().getText());
            
                  
        }
        
        if (evt.getActionCommand().equals("Alterar")) {
         
            this.modelo.atualizarTime(this.id,this.viewCdastroTime.getTxtNomeTime().getText());
            
        }
        
        if (evt.getActionCommand().equals("Excluir")) {
            
            this.modelo.excluirTime(id);
            
        }
    }

    public void trataEvento(MouseEvent evt) {
        
        Time time = (Time)(Object)this.viewCdastroTime.getjLista().getSelectedValue();
        this.id=time.getId();
        this.viewCdastroTime.getTxtNomeTime().setText(time.getNome());
        
        
    }
}