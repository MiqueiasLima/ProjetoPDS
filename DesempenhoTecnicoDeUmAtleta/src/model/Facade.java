/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class Facade {
    
    private Jogador Jogador;
    private Partida partida;
    private Time time;
    private Desempenho desempenho;

    public Facade() {
        
        this.Jogador=new Jogador();
        this.partida=new Partida();
        this.time= new Time();
        this.desempenho=new Desempenho();
    }
    
     private ArrayList<Observer> observadores = new ArrayList<>();
    
    public void notifyAllTo(){
        for(int i = 0; i < observadores.size(); i++){
            observadores.get(i).update();
        }
    }
    public void attach(Observer observer){
        this.observadores.add(observer);
    }
    
    public void dettach(Observer observer){
        this.observadores.remove(observer);
    }
    
    
    //fazer cadastrar,alterar e remover partida
    //Fazer cadastrar,alterar e remover Jogador
    //Fazer cadastrar,alterar e remover time
    //Fazer cadastrar,alterar e remover desempenho de um jogador
  
    //fazer consulta
    
    
    public void gerarRelatorio(){
    
    }
    
    
    public void cadastrarJogador(String nome, int idade, String posicao, int numero_uniforme, char melhor_pe){
        
        this.getJogador().CadastrarJogador(nome, idade, posicao, numero_uniforme, melhor_pe);
    }
    
    
    public void cadastrarPartida(String timeCasa,String timeFora, String Resultado,String competicao
     ,String tipoDeJogo){
    
        this.getPartida().cadastrarPartida(timeCasa, timeFora, Resultado, competicao, tipoDeJogo);
    
    }
    
    
    public void cadastrarTime(String nome, int[] jogadores){
        this.getTime().cadastrarTime(nome, jogadores);
    }
    
    public void cadastrarDesempenho(int id, int totalDePasses, int passesCertos, int passesErrados, int finalizacoesTotais, int finalizacoesGols, int dominioTotal, int dominioCerto, int dominioErrado, int desarme, int gol,
            int assistencia, int drible, Jogador jogador, Partida partida){
        
        this.getDesempenho().CadastrarDesempenho(id, totalDePasses, passesCertos, passesErrados, finalizacoesTotais, finalizacoesGols, dominioTotal, dominioCerto, dominioErrado, desarme, gol, assistencia, drible, jogador, partida);
        
    }
    
    public void alterarJogador(){
        
    }
    
    public void alterarPartida(){
    
    }
    
    public void alterarTime(){
    
    }
    
    public void alterarDesempenho(String nome, String passesTotais, String passesCertos, String passesErrados,
                                            String finalizacoesTotais, String finalizacaoGols, String dominioTotal,
                                            String dominioCerto, String dominioErrado, String desarme, String gol,
                                            String assistencia, String partida, String drible){
        
       
    }
    
    public void excluirJogador(){
        
    }
    
    public void excluirPartida(){
    
    }
    
    public void excluirTime(){
    
    }
    
    public void excluirDesempenho(){
    
    }
    
    
    
   

    public Jogador getJogador() {
        return Jogador;
    }

    public void setJogador(Jogador Jogador) {
        this.Jogador = Jogador;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Desempenho getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(Desempenho desempenho) {
        this.desempenho = desempenho;
    }
    
    
    
    
}
