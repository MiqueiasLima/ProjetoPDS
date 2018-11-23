/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Miqueias
 */
public class Desempenho {
    
    private int id;
    private int totalDePasses;
    private int passesCertos;
    private int passesErrados;
    private int finalizacoesTotais;
    private int finalizacoesGols;
    private int dominioTotal;
    private int dominioCerto;
    private int dominioErrado;
    private int desarme;
    private int gol;
    private int assistencia;
    private int drible;
    private Jogador jogador;
    private Partida partida;
    
    
    
    public void addJogador(){
    
    }
    
    

    public Desempenho(Jogador jogador, Partida partida) {
        
        this.setJogador(jogador);
        this.setPartida(partida);
    
    }

    public void CadastrarDesempenho(int id, int totalDePasses, int passesCertos, int passesErrados, int finalizacoesTotais, int finalizacoesGols, int dominioTotal, int dominioCerto, int dominioErrado, int desarme, int gol, int assistencia, int drible, Jogador jogador, Partida partida) {
        
        this.id = id;
        this.totalDePasses = totalDePasses;
        this.passesCertos = passesCertos;
        this.passesErrados = passesErrados;
        this.finalizacoesTotais = finalizacoesTotais;
        this.finalizacoesGols = finalizacoesGols;
        this.dominioTotal = dominioTotal;
        this.dominioCerto = dominioCerto;
        this.dominioErrado = dominioErrado;
        this.desarme = desarme;
        this.gol = gol;
        this.assistencia = assistencia;
        this.drible = drible;
        this.jogador = jogador;
        this.partida = partida;
        
        
    }
    
    
    

    
    
    
    
    public int getTotalDePasses() {
        return totalDePasses;
    }

    public void setTotalDePasses(int totalDePasses) {
        this.totalDePasses =this.totalDePasses+ totalDePasses;
    }

    public int getPassesCertos() {
        return passesCertos;
    }

    public void setPassesCertos(int passesCertos) {
        this.passesCertos = passesCertos;
        this.setTotalDePasses(passesCertos );
    }

    public int getPassesErrados() {
        return passesErrados;
    }

    public void setPassesErrados(int passesErrados) {
        this.passesErrados = passesErrados;
        this.setTotalDePasses(passesErrados);
    }

    public int getFinalizacoesTotais() {
        return finalizacoesTotais;
    }

    public void setFinalizacoesTotais(int finalizacoesTotais) {
        this.finalizacoesTotais = finalizacoesTotais;
    }

    public int getFinalizacoesGols() {
        return finalizacoesGols;
    }

    public void setFinalizacoesGols(int finalizacoesGols) {
        this.finalizacoesGols = finalizacoesGols;
    }

    public int getDominioTotal() {
        return dominioTotal;
    }

    public void setDominioTotal(int dominioTotal) {
        this.dominioTotal = dominioTotal;
    }

    public int getDominioCerto() {
        return dominioCerto;
    }

    public void setDominioCerto(int dominioCerto) {
        this.dominioCerto = dominioCerto;
    }

    public int getDominioErrado() {
        return dominioErrado;
    }

    public void setDominioErrado(int dominioErrado) {
        this.dominioErrado = dominioErrado;
    }

    public int getDesarme() {
        return desarme;
    }

    public void setDesarme(int desarme) {
        this.desarme = desarme;
    }

    public int getGol() {
        return gol;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }

    public int getAssistencia() {
        return assistencia;
    }

    public void setAssistencia(int assistencia) {
        this.assistencia = assistencia;
    }

    public int getDrible() {
        return drible;
    }

    public void setDrible(int drible) {
        this.drible = drible;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    
    
    
    
    
}
