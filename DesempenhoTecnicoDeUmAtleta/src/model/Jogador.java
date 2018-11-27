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
    
    private String posicao;
    private String DataDeNascimento;
    private int numero_uniforme;
    private char melhor_pe;
    private Time time;

    public Jogador(){
    
    }
    
    public Jogador( String nome, int idade, String posicao, int numero_uniforme, char melhor_pe) {
       
        this.nome = nome;
        
        this.posicao = posicao;
        this.numero_uniforme = numero_uniforme;
        this.melhor_pe = melhor_pe;
    }
    public void CadastrarJogador( String nome, int idade, String posicao, int numero_uniforme, char melhor_pe) {
       
        this.nome = nome;
        
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
        return "id=" + id + ", nome=" + nome + ", posicao=" + posicao + ", DataDeNascimento=" + DataDeNascimento + ", numero_uniforme=" + numero_uniforme + ", melhor_pe=" + melhor_pe + ", time=" + time;
    }
    
    
    

    
    
    
}
