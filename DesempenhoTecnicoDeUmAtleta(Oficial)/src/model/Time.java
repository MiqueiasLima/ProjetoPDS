/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DaoTime;
import java.util.List;

/**
 * @author ismael
 * @author Miqueias
 * @author José Evamberto
 */
public class Time {

    private int id;
    private String nome;
    private DaoTime daoTime ;

    public Time(String dao) {
        this.daoTime = new DaoTime();
    }
    public Time(){
    
    }
    public List nomeTime(){
        
        return this.daoTime.nomeTime();
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



    public Time(int id, String nome) {
        this.id = id;
        this.nome = nome;

    }
    
    

    public void cadastrarTime(String nome) {

        Time time = new Time();

        time.setNome(nome);

        this.getDaoTime().inserir(time);

    }
    public void atualizarTime(int id,String nome) {

        Time time = new Time();

        time.setNome(nome);
        time.setId(id);

        this.getDaoTime().atualizar(time);
        

    }
    
    public void excluirTime(int id){
        Time time = new Time();
        time.setId(id);
        this.getDaoTime().excluir(time);
        
    }
    
    public List buscarTime(){
        return this.getDaoTime().buscar();
    }

    @Override
    public String toString() {
        return    nome;
    }

    public DaoTime getDaoTime() {
        return daoTime;
    }

}
