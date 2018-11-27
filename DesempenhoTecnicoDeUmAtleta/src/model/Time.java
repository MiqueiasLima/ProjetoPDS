/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *@ismael
 * @author Miqueias
 * @author José Evamberto
 */
public class Time {
    
    private int id;
    private String nome;
    private int[] jogadores;
    
    public Time(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(int[] jogadores) {
        this.jogadores = jogadores;
    }

    public Time( String nome, int[] jogadores) {
   
        this.nome = nome;
        this.jogadores = jogadores;
    }

    public Time(int id, String nome, int[] jogadores) {
        this.id = id;
        this.nome = nome;
        this.jogadores = jogadores;
    }
    
    
    
    public void cadastrarTime( String nome, int[] jogadores) {
        
        
        this.nome = nome;
        this.jogadores = jogadores;
        
    }

    @Override
    public String toString() {
        return  "id=" + id + ", nome=" + nome + ", jogadores=" + jogadores;
    }
    
    
    
    
    
}
