/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Facade {

    private Jogador Jogador;
    private Partida partida;
    private Time time;
    private Desempenho desempenho;
    private ArrayList<Observer> observadores = new ArrayList<>();

    public Facade() {

        this.Jogador = new Jogador("dao");
        this.partida = new Partida("dao");
        this.time = new Time("dao");
        this.desempenho = new Desempenho("dao");
    }

    public void notifyAllTo() {
        for (int i = 0; i < observadores.size(); i++) {
            observadores.get(i).update();
        }
    }
    
    public List nomeTime(){
        return time.nomeTime();
    }
    public void attach(Observer observer) {
        this.observadores.add(observer);
    }

    public void dettach(Observer observer) {
        this.observadores.remove(observer);
    }

    public void gerarRelatorio(String tipoRelatorio, Time time, Partida partida) {
        

        if (tipoRelatorio.equals("Relatório Equipe")) {
            Relatorio relatorio = new RelatorioEquipe(time, partida);
            relatorio.templateMethod();

        }
        if (tipoRelatorio.equals("Relatório Jogador")) {
            Relatorio relatorio = new RelatorioJogador(time, partida);
            relatorio.templateMethod();

        }

    }

    public void cadastrarJogador(String nome, String DataNascimento, String posicao, char melhor_pe, Time time) {
        
        this.getJogador().cadastrarJogador(nome, DataNascimento, posicao, melhor_pe, time);
        this.notifyAllTo();
    }

    public void atualizarJogador(int id, String nome, String dataNascimento, String posicao, char melhor_pe, Time time) {

        this.getJogador().atualizarJogador(id, nome, dataNascimento,posicao, melhor_pe, time);
        this.notifyAllTo();
    }

    public void excluirJogador(int id) {
        this.getJogador().excluirJogador(id);
        this.notifyAllTo();
    }

    public List BuscarJogador() {

        return this.getJogador().buscarJogador();
    }
    public Jogador BuscarJogadorPeloId(int id) {

        return this.getJogador().buscarJogadorPeloId(id);
    }

    public void cadastrarPartida(String timeCasa, String timeFora, String resultado,
             String tipoDeJogo, String horario, String data, String localDaPartida) {
        

        this.getPartida().cadastrarPartida(timeCasa, timeFora, resultado,
                 tipoDeJogo, horario, data, localDaPartida);
        
        
        this.notifyAllTo();

    }

    public void atualizarPartida(int id, String timeCasa, String timeFora, String resultado, 
             String tipoDeJogo, String horario, String data, String localDaPartida) {

        this.getPartida().atualizarPartida(id, timeCasa, timeFora, resultado, 
                 tipoDeJogo, horario, data, localDaPartida);
        this.notifyAllTo();

    }

    public void excluirPartida(int id) {
        this.getPartida().excluirPartida(id);
        this.notifyAllTo();
    }

    public List buscarPartida() {

        return this.getPartida().buscarPartida();
    }

    public void cadastrarTime(String nome) {

        this.getTime().cadastrarTime(nome);
        this.notifyAllTo();
    }

    public void atualizarTime(int id, String nome) {
        this.getTime().atualizarTime(id, nome);
        this.notifyAllTo();
    }

    public void excluirTime(int id) {
        this.getTime().excluirTime(id);
        this.notifyAllTo();
    }

    public List buscarTime() {
        return this.getTime().buscarTime();
    }

    public void cadastrarDesempenho( int passesCertos, int passesErrados, int finalizacoesGols, int dominioTotal, int dominioCerto, int dominioErrado, int desarme, int gol,
            int assistencia, int drible, Jogador jogador, Partida partida) {

        this.getDesempenho().cadastrarDesempenho( passesCertos, passesErrados, finalizacoesGols, dominioTotal, dominioCerto, dominioErrado, desarme, gol, assistencia, drible, jogador, partida);
        this.notifyAllTo();

    }

    public void atualizarDesempenho(int id, int passesCertos, int passesErrados,  int finalizacoesGols, int dominioTotal, int dominioCerto, int dominioErrado, int desarme, int gol,
            int assistencia, int drible, Jogador jogador, Partida partida) {

        this.getDesempenho().atualizarDesempenho(id,  passesCertos, passesErrados,  finalizacoesGols, dominioTotal, dominioCerto, dominioErrado, desarme, gol, assistencia, drible, jogador, partida);
        this.notifyAllTo();
    }

    public void excluirDesempenho(int id) {

        this.getDesempenho().excluirDesempenho(id);
        this.notifyAllTo();

    }
    
   

    public List buscarDesempenho() {
        return this.getDesempenho().buscarDesempenho();
    }
    public List buscarDesempenhoPartida(Partida partida) {
        return this.getDesempenho().buscarDesempenhoPartida(partida);
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
