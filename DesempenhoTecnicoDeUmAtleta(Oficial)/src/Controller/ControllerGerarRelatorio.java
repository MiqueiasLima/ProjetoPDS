/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import model.Facade;
import model.Observer;
import model.Partida;
import model.Time;
import view.ViewGerarRelatorio;

/**
 *
 * @author jose
 */
public class ControllerGerarRelatorio implements Observer {

    
    private Facade modelo;
    private ViewGerarRelatorio view;
    public ControllerGerarRelatorio(Facade modelo, ViewGerarRelatorio view) {
        this.modelo=modelo;
        this.view=view;
    }

    @Override
    public void update() {
       
    }

    public void trataEvento(ActionEvent evt) {
        if (evt.getActionCommand().equals("Gerar Relatório")) {
            
            Time time= (Time) this.view.getjCombTime2().getSelectedItem();
            Partida partida =(Partida) this.view.getjComboPartida1().getSelectedItem();
            String tipoRelatorio= (String) this.view.getJCombRelato().getSelectedItem();
     
            this.modelo.gerarRelatorio(tipoRelatorio, time, partida);
            
        }
        
        if (evt.getActionCommand().equals("Fechar")) {
            this.view.dispose();
        }
    }

   
    }
    
    
    

