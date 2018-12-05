/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DaoJogador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miqueias
 */
public class Jogador {

    private int id;
    private String nome;
    private DaoJogador daoJogador;
    private String posicao;
    private String DataDeNascimento;
    private int numero_uniforme;
    private char melhor_pe;
    private Time time;

    
    
    public Jogador(){
    
    
    }
    public Jogador(String dao){
        if (dao.equals("dao")) {
            this.daoJogador= new DaoJogador();
        }
        
    
    }
    
    public Jogador( String nome, String dataNascimento, String posicao, int numero_uniforme, char melhor_pe) {
       
        this.nome = nome;
        
        this.posicao = posicao;
        this.numero_uniforme = numero_uniforme;
        this.melhor_pe = melhor_pe;
    }
    public void cadastrarJogador( String nome,String dataNascimento, String posicao, char melhor_pe, Time time) {
       
        
        Jogador jogador =new Jogador ();
        jogador.setNome(nome);
        jogador.setMelhor_pe(melhor_pe);
        jogador.setDataDeNascimento(dataNascimento);
        jogador.setPosicao(posicao);
        
        jogador.setTime(time);
        
        this.daoJogador.inserir(jogador);
    }
    public void atualizarJogador(int id, String nome, String dataNascimento,String posicao,  char melhor_pe, Time time) {
       
        
        Jogador jogador =new Jogador ();
        jogador.setId(id);
        jogador.setNome(nome);
        jogador.setMelhor_pe(melhor_pe);
        jogador.setDataDeNascimento(dataNascimento);
        jogador.setPosicao(posicao);
        
        jogador.setTime(time);
        
        this.daoJogador.atualizar(jogador);
    }
    public void excluirJogador(int id) {
       
        
        Jogador jogador =new Jogador ();
        jogador.setId(id);
        
        this.daoJogador.excluir(jogador);
    }
    public List buscarJogador(){
    
            ArrayList lista = (ArrayList) daoJogador.buscar();
    
            return lista;
    }
    
    
    
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }




    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getNumero_uniforme() {
        return numero_uniforme;
    }

    public void setNumero_uniforme(int numero_uniforme) {
        this.numero_uniforme = numero_uniforme;
    }

    public char getMelhor_pe() {
        return melhor_pe;
    }

    public void setMelhor_pe(char melhor_pe) {
        this.melhor_pe = melhor_pe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataDeNascimento() {
        return DataDeNascimento;
    }

    public void setDataDeNascimento(String DataDeNascimento) {
        this.DataDeNascimento = DataDeNascimento;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return   nome + " , " + posicao;
    }

    public DaoJogador getDaoJogador() {
        return daoJogador;
    }

    public Jogador buscarJogadorPeloId(int id) {
      Jogador jogador=this.getDaoJogador().buscarJogadorPeloId(id);
      return jogador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogador other = (Jogador) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    
    
    

    
    
    
}
