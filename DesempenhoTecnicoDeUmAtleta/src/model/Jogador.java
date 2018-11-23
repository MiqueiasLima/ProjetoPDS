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
public class Jogador {

    private int id;
    private String nome;
    private int idade;
    private String posicao;
    private int numero_uniforme;
    private char melhor_pe;

    public Jogador( String nome, int idade, String posicao, int numero_uniforme, char melhor_pe) {
       
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
        this.numero_uniforme = numero_uniforme;
        this.melhor_pe = melhor_pe;
    }
    
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
    
    
    
}
