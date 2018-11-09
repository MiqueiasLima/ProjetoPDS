/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import pipes.Observer;
import View.View;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import pipes.ModeloPipes;



public class ControllerView implements Observer{

    ArrayList <String> fila = new ArrayList<>();
    
    ModeloPipes modeloPipes;
    View view;
    
    public ControllerView(ModeloPipes modeloPipes, View view){
        this.modeloPipes = modeloPipes;
        this.view = view;
        this.modeloPipes.attach(this);
        
    }
    
    public void trataEvento(java.awt.event.ActionEvent evt){
        
        if("Minúsculo".equals(evt.getActionCommand()) && this.view.getjMin().isSelected()){
                fila.add("Minúsculo");
        }
        
        if("Maiúsculo".equals(evt.getActionCommand()) && this.view.getjMai().isSelected()){
                fila.add("Maiúsculo");
        }
        
        if("Inverter".equals(evt.getActionCommand()) && this.view.getjInv().isSelected()){
                fila.add("Inverter");
        }
        if("Tirar Vogais".equals(evt.getActionCommand()) && this.view.getjTv().isSelected()){
                fila.add("Tirar Vogais");
        }
        if("Tirar Consoantes".equals(evt.getActionCommand()) && this.view.getjTc().isSelected()){
                fila.add("Tirar Consoantes");
        }
        this.removeEvento(evt);
    }
     
        public void removeEvento(java.awt.event.ActionEvent evt){
            if("Maiúsculo".equals(evt.getActionCommand()) && this.view.getjMai().isSelected()==false){
                fila.remove("Maiúsculo");
        }
        if( "Minúsculo".equals(evt.getActionCommand()) && this.view.getjMin().isSelected()==false){
                fila.remove("Minúsculo");
        }
        if( "Inverter".equals(evt.getActionCommand()) && this.view.getjInv().isSelected()==false){
                fila.remove("Inverter");
        }
        if( "Tirar Vogais".equals(evt.getActionCommand()) && this.view.getjTv().isSelected()==false){
                fila.remove("Tirar Vogais");
        }
        if( "Tirar Consoantes".equals(evt.getActionCommand()) && this.view.getjTc().isSelected()==false){
                fila.remove("Tirar Consoantes");
        }
           
     }
    
    @Override
    public void update() {
       
    }

    public void botaoAcionado(ActionEvent evt) {
        if("Gerar".equals(evt.getActionCommand())){
            this.modeloPipes.ordena(fila, this.view.getjNome().getText());
        
        String ordem = "";
            for (int i = 0; i < fila.size(); i++) {
                ordem = ordem+" "+fila.get(i);
                
            }
        this.view.getjOrdem().setText(ordem);
        }
    }
    
}
