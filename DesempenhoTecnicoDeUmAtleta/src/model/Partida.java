/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author Evamberto
 * @author Miqueias
 * @author Ismael
 */
public class Partida {
   
   private int id;
   private String timeCasa;
   private String timeFora;
   private String resultado;
   private String competicao;

    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeFora() {
        return timeFora;
    }

    public void setTimeFora(String timeFora) {
        this.timeFora = timeFora;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getCompeticao() {
        return competicao;
    }

    public void setCompeticao(String competicao) {
        this.competicao = competicao;
    }
   public  Partida(String timeCasa,String timeFora, String Resultado,String competicao
   ,String tipoDeJogo){
       
       this.setTimeCasa(timeCasa);
       this.setTimeFora(timeFora);
       this.setResultado(Resultado);
       this.setCompeticao(competicao);
       
   }
   
   
    public Partida(){
    }
   
   
      public void  cadastrarPartida(String timeCasa,String timeFora, String Resultado,String competicao
     ,String tipoDeJogo){
       
       this.setTimeCasa(timeCasa);
       this.setTimeFora(timeFora);
       this.setResultado(Resultado);
       this.setCompeticao(competicao);
       
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
      
   
   
    
  }
    
