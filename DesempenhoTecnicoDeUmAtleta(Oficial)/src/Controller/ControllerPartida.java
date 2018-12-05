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
import model.Partida;
import view.CadastrarPartida;
import view.ViewCadastroTime;

/**
 *
 * @author Miqueias
 */
public class ControllerPartida implements Observer{

    private Facade modelo;
    private CadastrarPartida cadastrarPartida;
    private int id;
    
    public ControllerPartida(Facade modelo, CadastrarPartida cadastrarPartida){
        this.modelo = modelo;
        this.cadastrarPartida = cadastrarPartida;
        
        this.modelo.attach(this);
    
    }
    
    
    @Override
    public void update() {
       
    }

    public void trataEvento(MouseEvent evt) {
        
         Partida partida = (Partida)(Object)this.cadastrarPartida.getjList1().getSelectedValue();
        this.id=partida.getId();
        
        this.cadastrarPartida.getTxtData().setText(partida.getData());
        this.cadastrarPartida.getTxtHorario().setText(partida.getHorario());
        this.cadastrarPartida.getTxtLocalPartida().setText(partida.getLocalDaPartida());
        this.cadastrarPartida.getTxtResultado().setText(partida.getResultado());
        this.cadastrarPartida.getTxtTimeCasa().setText(partida.getTimeCasa());
        this.cadastrarPartida.getTxtTimeFora().setText(partida.getTimeFora());
        this.cadastrarPartida.getTxtTipoDeJogo().setText(partida.getTipoDeJogo());
       
    }

    public void trataEvt(ActionEvent evt) {
        if (evt.getActionCommand().equals("Cadastrar")) {
            
            this.modelo.cadastrarPartida(this.cadastrarPartida.getTxtTimeCasa().getText(), this.cadastrarPartida.getTxtTimeFora().getText(), this.cadastrarPartida.getTxtResultado().getText(),this.cadastrarPartida.getTxtTipoDeJogo().getText(), this.cadastrarPartida.getTxtHorario().getText(), this.cadastrarPartida.getTxtData().getText(),this.cadastrarPartida.getTxtLocalPartida().getText());
            
        }
        if (evt.getActionCommand().equals("Alterar")) {
             this.modelo.atualizarPartida(id,this.cadastrarPartida.getTxtTimeCasa().getText(), this.cadastrarPartida.getTxtTimeFora().getText(), this.cadastrarPartida.getTxtResultado().getText(),this.cadastrarPartida.getTxtTipoDeJogo().getText(), this.cadastrarPartida.getTxtHorario().getText(), this.cadastrarPartida.getTxtData().getText(),this.cadastrarPartida.getTxtLocalPartida().getText());
            
        }
        
        if ("Excluir".equals(evt.getActionCommand())) {
            
            this.modelo.excluirPartida(id);
            
        }
        
        if ("Fechar".equals(evt.getActionCommand())) {
            
            this.cadastrarPartida.dispose();
        }
    }
    
}
