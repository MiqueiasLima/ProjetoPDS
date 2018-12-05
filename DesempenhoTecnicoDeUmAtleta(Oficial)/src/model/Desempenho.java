/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DaoDesempenho;
import java.util.List;

/**
 * @author  Evamberto
 * @author Miqueias
 * @author Ismael
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
    private DaoDesempenho DaoDesempenho;
    
    
    
    public Desempenho(){
        
    }
    public Desempenho(String dao){
        
        
        if (dao.equals("dao")) {
            DaoDesempenho= new DaoDesempenho();
        }
        
    
    }
    
    
   
    
    

    public Desempenho(Jogador jogador, Partida partida) {
        
        this.setJogador(jogador);
        this.setPartida(partida);
    
    }

    public void cadastrarDesempenho(  int passesCertos, int passesErrados, int finalizacoesGols, int dominioTotal, int dominioCerto, int dominioErrado, int desarme, int gol, int assistencia, int drible, Jogador jogador, Partida partida) {
        
        Desempenho desempenho = new Desempenho();
        
        int total = passesCertos+passesErrados;
        desempenho.setTotalDePasses(total);
        desempenho.setFinalizacoesTotais(finalizacoesGols+gol);
        desempenho.setPassesCertos(passesCertos);
        
        desempenho.setPassesErrados(passesErrados);
        
        desempenho.setFinalizacoesGols(finalizacoesGols);
        desempenho.setDominioTotal(dominioTotal);
        
        desempenho.setDominioCerto(dominioCerto);
        desempenho.setDominioErrado(dominioErrado);
        desempenho.setDesarme(desarme);
        desempenho.setGol(gol);
        desempenho.setAssistencia(assistencia);
        desempenho.setDrible(drible);
        
        desempenho.setJogador(jogador);
        desempenho.setPartida(partida);
        
        this.getDaoDesempenho().inserir(desempenho);
        
        
    }
    public void atualizarDesempenho(int id, int passesCertos, int passesErrados, int finalizacoesGols, int dominioTotal, int dominioCerto, int dominioErrado, int desarme, int gol, int assistencia, int drible, Jogador jogador, Partida partida) {
        
        Desempenho desempenho = new Desempenho();
        
        desempenho.setId(id);
           int total = passesCertos+passesErrados;
        desempenho.setTotalDePasses(total);
        desempenho.setFinalizacoesTotais(finalizacoesGols+gol);
        desempenho.setPassesCertos(passesCertos);
        
        desempenho.setPassesErrados(passesErrados);
        
        desempenho.setFinalizacoesGols(finalizacoesGols);
        desempenho.setDominioTotal(dominioTotal);
        
        desempenho.setDominioCerto(dominioCerto);
        desempenho.setDominioErrado(dominioErrado);
        desempenho.setDesarme(desarme);
        desempenho.setGol(gol);
        desempenho.setAssistencia(assistencia);
        desempenho.setDrible(drible);
        
        desempenho.setJogador(jogador);
        desempenho.setPartida(partida);
        
        this.getDaoDesempenho().atualizar(desempenho);
        
        
    }
    
   
    
    public void excluirDesempenho( int id ){
    
        Desempenho desempenho= new Desempenho();
        desempenho.setId(id);
        this.DaoDesempenho.excluir(desempenho);
        
    }
    
    public List buscarDesempenho(){
        return  this.getDaoDesempenho().buscar();
    }
    public List buscarDesempenhoPartida(Partida partida){
        return  this.getDaoDesempenho().buscarDesempenhoPartida(partida);
    }
    
   
    
    
    
    
    public int getTotalDePasses() {
        return totalDePasses;
    }

    public void setTotalDePasses(int totalDePasses) {
        
        this.totalDePasses =totalDePasses;
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

    @Override
    public String toString() {
        return  " passesCertos:" + passesCertos + " Passes errados:" + passesErrados + " Finalizações gols:" + finalizacoesGols + " Domínio total: " + dominioTotal + " Domínio certo:" + dominioCerto + ", Dominio errado:" + dominioErrado + " Desarme:" + desarme + " Gol=" + gol + " Assistencia:" + assistencia + ", Drible:" + drible;
    }

    public DaoDesempenho getDaoDesempenho() {
        return DaoDesempenho;
    }

  
    
    
    
    
    
}
