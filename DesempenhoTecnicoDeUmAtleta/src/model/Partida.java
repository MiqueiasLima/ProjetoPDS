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
   private String tipoDeJogo;
   private String horario;
   private String localDaPartida;
   private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
   
   
   
   
   
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

    public String getLocalDaPartida() {
        return localDaPartida;
    }

    public void setLocalDaPartida(String localDaPartida) {
        this.localDaPartida = localDaPartida;
    }

 

    public String getTipoDeJogo() {
        return tipoDeJogo;
    }

    public void setTipoDeJogo(String tipoDeJogo) {
        this.tipoDeJogo = tipoDeJogo;
    }
    
    
   public  Partida(String timeCasa,String timeFora, String Resultado,String competicao
   ,String tipoDeJogo){
       
       this.setTimeCasa(timeCasa);
       this.setTimeFora(timeFora);
       this.setResultado(Resultado);
       
       
   }
   
   
    public Partida(){
    }
   
   
      public void  cadastrarPartida(String timeCasa,String timeFora, String Resultado,String competicao
     ,String tipoDeJogo){
       
       this.setTimeCasa(timeCasa);
       this.setTimeFora(timeFora);
       this.setResultado(Resultado);
       
       
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return  "id=" + id + ", timeCasa=" + timeCasa + ", timeFora=" + timeFora + ", resultado=" + resultado + ", tipoDeJogo=" + tipoDeJogo + ", horario=" + horario + ", localDaPartida=" + localDaPartida + ", data=" + data ;
    }
   
      
   
   
    
  }
    
