/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipes;


import java.util.ArrayList;

/**
 *
 * @author Miqueias
 */
public class ModeloPipes {
    
    private String nome;
    private char[] array;
    
    ArrayList <Observer> observadores = new ArrayList<>();
    
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
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null){
        this.nome = nome;
        this.notifyAllTo();
      }
    }
  
    public String deixaMaisculo(String string){
        
        string = string.toUpperCase();
        return string;    

    }
    
    public String deixaMinusculo(String string){
    
        string = string.toLowerCase();
        return string;
    } 
    
    public String inverte(String string){
        int j = 0;
        array = string.toCharArray();
        char[] nome = new char[array.length]; 
        for(int i = array.length-1; i>=0;i--){
                nome[j] = array[i];
                j++;
            } 
        string = "";
        for(int i = 0; i<nome.length;i++){
                string = string+nome[i];
           }
        return string;
    }
    
    public String tiraVogais(String string){
        string = string.replace('A','\u0000');
        string = string.replace('E','\u0000');
        string = string.replace('I','\u0000');
        string = string.replace('O','\u0000');
        string = string.replace('U','\u0000');
        string = string.replace('a','\u0000');
        string = string.replace('e','\u0000');
        string = string.replace('i','\u0000');
        string = string.replace('o','\u0000');
        string = string.replace('u','\u0000');
      return string;
    }
    
    public String tiraConsoantes(String string){
        char[] array = string.toCharArray();
              for(int i = 0; i<array.length;i++){
                  if(array[i]=='A' || array[i]== 'E' || array[i]== 'I' || array[i]== 'O' ||
                          array[i]== 'U' || array[i]== 'a' || array[i]== 'e'|| array[i]== 'i'|| array[i] == 'o'||
                          array[i]== 'u'){
                          continue;
                  }
                  else{
                     string = string.replace(array[i],'\u0000');
                  }
              }
    return string;   
    }
    
    public void ordena(ArrayList<String> string, String nome){
        
    
        for(int i = 0; i<string.size();i++){
            if("Maiúsculo".equals(string.get(i))){
                nome=this.deixaMaisculo(nome);
                
            }
            if("Minúsculo".equals(string.get(i))){
                nome = this.deixaMinusculo(nome);
              
            }
            if("Inverter".equals(string.get(i))){
                nome = this.inverte(nome);
                
            }
            if("Tirar Vogais".equals(string.get(i))){
                nome = this.tiraVogais(nome);
                
            }
            if("Tirar Consoantes".equals(string.get(i))){
                nome = this.tiraConsoantes(nome);
                
            }
        }
        this.nome = nome;
        this.notifyAllTo();
    }
}
