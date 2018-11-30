/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jose
 */
public abstract class  Relatorio {
    Desempenho desempenho;
    Time time;
    
    
    public void templateMethod(){
        
    }
    
    public void fazerRelatorioJogador(){
    
    }
    
    public void fazerRelatorioEquipe(){
    
    }
    
    

    public Desempenho getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(Desempenho desempenho) {
        this.desempenho = desempenho;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    
    
}
