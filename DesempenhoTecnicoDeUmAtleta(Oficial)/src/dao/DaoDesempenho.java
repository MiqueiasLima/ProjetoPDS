/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionPool.Conexao;
import connectionPool.ConnectionPool;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Desempenho;
import model.Jogador;
import model.Partida;
import model.Time;

/**
 *
 * @author jose
 */
public class DaoDesempenho  implements Dao{
    private ConnectionPool pool;
    private Conexao conexao;
    public DaoDesempenho(){
        this.pool= new ConnectionPool("jdbc:mysql://localhost:3306/mydb", "root", "peken", "com.mysql.jdbc.Driver");
    }

    @Override
    public boolean inserir(Object object) {
        
        Desempenho desempenho = (Desempenho) object;
             
     
        this.conexao=this.pool.getConnection();
        String sql=" INSERT INTO desempenho (passesTotais,passesCertos,passesErrados,finalizacoesTotais,finalizacoesGols,dominioTotal,dominioCerto,dominioErrado,desarme,gol"
                + ",assistencia,drible,partida_id,jogador_id)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            
            this.conexao.getStmt().setInt(1, (desempenho.getPassesCertos()+desempenho.getPassesErrados()));
            this.conexao.getStmt().setInt(2, desempenho.getPassesCertos());
            this.conexao.getStmt().setInt(3, desempenho.getPassesErrados());
            this.conexao.getStmt().setInt(4, desempenho.getFinalizacoesTotais());
            this.conexao.getStmt().setInt(5, desempenho.getFinalizacoesGols());
            this.conexao.getStmt().setInt(6, desempenho.getDominioTotal());
            this.conexao.getStmt().setInt(7, desempenho.getDominioCerto());
            this.conexao.getStmt().setInt(8, desempenho.getDominioErrado());
            this.conexao.getStmt().setInt(9, desempenho.getDesarme());
            this.conexao.getStmt().setInt(10, desempenho.getGol());
            this.conexao.getStmt().setInt(11, desempenho.getAssistencia());
            this.conexao.getStmt().setInt(12, desempenho.getDrible());
            this.conexao.getStmt().setInt(13, desempenho.getPartida().getId());
           
            this.conexao.getStmt().setInt(14, desempenho.getJogador().getId());
            this.conexao.getStmt().execute();
            
            return true;
        } catch (SQLException ex) {
           System.err.println("erro:"+ex);
           return false;
           
        }finally{
            
            this.pool.devolveConexao(conexao);
            this.conexao=null;
            
        }
        
    }

    @Override
    public boolean excluir(Object object) {
       Desempenho desempenho= (Desempenho)object;
       this.conexao=this.pool.getConnection();
       String sql="DELETE FROM desempenho WHERE id=?";
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1, desempenho.getId());
            this.conexao.getStmt().execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        }finally{
            this.pool.devolveConexao(conexao);
            this.conexao=null;
        }
       
    }

    @Override
    public boolean atualizar(Object object) {
       
        Desempenho desempenho = (Desempenho) object;
        
        
        this.conexao=this.pool.getConnection();
        String sql=" UPDATE  desempenho SET passesTotais=?,passesCertos=?,passesErrados=?,finalizacoesTotais=?,finalizacoesGols=?,dominioTotal=?,dominioCerto=?,dominioErrado=?,desarme=?,gol=?"
                + ",assistencia=?,drible=?,partida_id=?,jogador_id=?"
                + " WHERE id=?";
        
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            
            this.conexao.getStmt().setInt(1, (desempenho.getPassesCertos()+desempenho.getPassesErrados()));
            this.conexao.getStmt().setInt(2, desempenho.getPassesCertos());
            this.conexao.getStmt().setInt(3, desempenho.getPassesErrados());
            this.conexao.getStmt().setInt(4, desempenho.getFinalizacoesTotais());
            this.conexao.getStmt().setInt(5, desempenho.getFinalizacoesGols());
            this.conexao.getStmt().setInt(6, desempenho.getDominioTotal());
            this.conexao.getStmt().setInt(7, desempenho.getDominioCerto());
            this.conexao.getStmt().setInt(8, desempenho.getDominioErrado());
            this.conexao.getStmt().setInt(9, desempenho.getDesarme());
            this.conexao.getStmt().setInt(10, desempenho.getGol());
            this.conexao.getStmt().setInt(11, desempenho.getAssistencia());
            this.conexao.getStmt().setInt(12, desempenho.getDrible());
            this.conexao.getStmt().setInt(13, desempenho.getPartida().getId());
            this.conexao.getStmt().setInt(14, desempenho.getJogador().getId());
            this.conexao.getStmt().setInt(15,desempenho.getId());
            this.conexao.getStmt().executeUpdate();
            
            return true;
        } catch (SQLException ex) {
           System.err.println("erro:"+ex);
           return false;
           
        }finally{
            
            this.pool.devolveConexao(conexao);
            this.conexao=null;
            
        }
    }

    @Override
    public List buscar() {
       ArrayList<Desempenho> lista = new ArrayList();
       
       this.conexao=this.pool.getConnection();
       String sql ="SELECT * FROM desempenho";
       
        try {
            
            
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
            
              Partida partida = new Partida();
              Jogador jogador = new Jogador();
                Desempenho desempenho = new Desempenho();
                    desempenho.setTotalDePasses(this.conexao.getRs().getInt("passesTotais"));
                   
                    desempenho.setPassesCertos(this.conexao.getRs().getInt("passesCertos"));
                    desempenho.setPassesErrados(this.conexao.getRs().getInt("passesErrados"));
                    desempenho.setFinalizacoesTotais(this.conexao.getRs().getInt("finalizacoesTotais"));
                    desempenho.setFinalizacoesGols(this.conexao.getRs().getInt("finalizacoesGols"));
                    desempenho.setDominioTotal(this.conexao.getRs().getInt("dominioTotal"));
                    desempenho.setDominioCerto(this.conexao.getRs().getInt("dominioCerto"));
                    desempenho.setDominioErrado(this.conexao.getRs().getInt("dominioErrado"));
                    desempenho.setDesarme(this.conexao.getRs().getInt("desarme"));
                    desempenho.setGol(this.conexao.getRs().getInt("gol"));
                    desempenho.setAssistencia(this.conexao.getRs().getInt("assistencia"));
                    desempenho.setDrible(this.conexao.getRs().getInt("drible"));
                    desempenho.setPartida(partida);
                    desempenho.setJogador(jogador);
                    desempenho.getPartida().setId(this.conexao.getRs().getInt("partida_id"));
                    desempenho.getJogador().setId(this.conexao.getRs().getInt("jogador_id"));
                    desempenho.setId(this.conexao.getRs().getInt("id"));
                    lista.add(desempenho);
                
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }finally{
            this.pool.devolveConexao(conexao);
            this.conexao = null;
        }
        
       return lista;
    }
    
    
     //select * from jogador INNER JOIN partida ON partida.id=1  INNER JOIN  desempenho ON desempenho.id=1 WHERE jogador.time_id=1 ;
    
     public List relatorioPasse(Time time, Partida partida1) {
       ArrayList<Desempenho> lista = new ArrayList();
       
       this.conexao=this.pool.getConnection();
       String sql ="select nome,passesCertos,passesErrados,passesTotais from jogador INNER JOIN desempenho ON desempenho.jogador_id=jogador.id where desempenho.partida_id=? ";
       
        try {
            
            
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1,partida1.getId());
            
            
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
            
              Partida partida = new Partida();
              Jogador jogador = new Jogador();
                Desempenho desempenho = new Desempenho();
                    desempenho.setTotalDePasses(this.conexao.getRs().getInt("passesTotais"));
                    desempenho.setPassesCertos(this.conexao.getRs().getInt("passesCertos"));
                    desempenho.setPassesErrados(this.conexao.getRs().getInt("passesErrados"));

                    desempenho.setPartida(partida);
                    desempenho.setJogador(jogador);
                    
                    desempenho.getJogador().setNome(this.conexao.getRs().getString("nome"));
                    
                    lista.add(desempenho);
                
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }finally{
            this.pool.devolveConexao(conexao);
            this.conexao = null;
        }
        
       return lista;
    }
     public List relatorioDominio(Time time, Partida partida1) {
       ArrayList<Desempenho> lista = new ArrayList();
       
       this.conexao=this.pool.getConnection();
       String sql ="select nome,dominioCerto, dominioErrado,dominioTotal  from jogador INNER JOIN desempenho ON desempenho.jogador_id=jogador.id where desempenho.partida_id=? ";
       
        try {
            
            
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1,partida1.getId());
          
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
            
              Partida partida = new Partida();
              Jogador jogador = new Jogador();
                Desempenho desempenho = new Desempenho();
                    
                
                    desempenho.setDominioTotal(this.conexao.getRs().getInt("dominioTotal"));
                    desempenho.setDominioCerto(this.conexao.getRs().getInt("dominioCerto"));
                    desempenho.setDominioErrado(this.conexao.getRs().getInt("dominioErrado"));             
                    desempenho.setPartida(partida);
                    desempenho.setJogador(jogador);
                  
                    desempenho.getJogador().setNome(this.conexao.getRs().getString("nome"));
                   
                    lista.add(desempenho);
                
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }finally{
            this.pool.devolveConexao(conexao);
            this.conexao = null;
        }
        
       return lista;
    }
     public List relatorioFinalizacao(Time time, Partida partida1) {
       ArrayList<Desempenho> lista = new ArrayList();
       
       this.conexao=this.pool.getConnection();
       String sql ="select nome,drible,assistencia,desarme,gol,finalizacoesGols,finalizacoesTotais  from jogador INNER JOIN desempenho ON desempenho.jogador_id=jogador.id where desempenho.partida_id=? ";
       
        try {
            
            
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1,partida1.getId());

            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
            
              Partida partida = new Partida();
              Jogador jogador = new Jogador();
                Desempenho desempenho = new Desempenho();
                    
                    desempenho.setFinalizacoesTotais(this.conexao.getRs().getInt("finalizacoesTotais"));
                    desempenho.setFinalizacoesGols(this.conexao.getRs().getInt("finalizacoesGols"));
                    
                    desempenho.setDesarme(this.conexao.getRs().getInt("desarme"));
                    desempenho.setGol(this.conexao.getRs().getInt("gol"));
                    desempenho.setAssistencia(this.conexao.getRs().getInt("assistencia"));
                    desempenho.setDrible(this.conexao.getRs().getInt("drible"));
                    desempenho.setPartida(partida);
                    desempenho.setJogador(jogador);
                    
                     desempenho.getJogador().setNome(this.conexao.getRs().getString("nome"));
                  
                    lista.add(desempenho);
                
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }finally{
            this.pool.devolveConexao(conexao);
            this.conexao = null;
        }
        
       return lista;
    }
     
     
     
     
     
      public List buscarDesempenhoPartida(Partida partida1) {
       ArrayList<Desempenho> lista = new ArrayList();
       
       this.conexao=this.pool.getConnection();
       String sql ="SELECT * FROM desempenho WHERE partida_id=? ";
       
        try {
            
            
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1, partida1.getId());
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
            
              Partida partida = new Partida();
              Jogador jogador = new Jogador();
                Desempenho desempenho = new Desempenho();
                    desempenho.setTotalDePasses(this.conexao.getRs().getInt("passesTotais"));
                   
                    desempenho.setPassesCertos(this.conexao.getRs().getInt("passesCertos"));
                    desempenho.setPassesErrados(this.conexao.getRs().getInt("passesErrados"));
                    desempenho.setFinalizacoesTotais(this.conexao.getRs().getInt("finalizacoesTotais"));
                    desempenho.setFinalizacoesGols(this.conexao.getRs().getInt("finalizacoesGols"));
                    desempenho.setDominioTotal(this.conexao.getRs().getInt("dominioTotal"));
                    desempenho.setDominioCerto(this.conexao.getRs().getInt("dominioCerto"));
                    desempenho.setDominioErrado(this.conexao.getRs().getInt("dominioErrado"));
                    desempenho.setDesarme(this.conexao.getRs().getInt("desarme"));
                    desempenho.setGol(this.conexao.getRs().getInt("gol"));
                    desempenho.setAssistencia(this.conexao.getRs().getInt("assistencia"));
                    desempenho.setDrible(this.conexao.getRs().getInt("drible"));
                    desempenho.setPartida(partida);
                    desempenho.setJogador(jogador);
                    desempenho.getPartida().setId(this.conexao.getRs().getInt("partida_id"));
                    desempenho.getJogador().setId(this.conexao.getRs().getInt("jogador_id"));
                    desempenho.setId(this.conexao.getRs().getInt("id"));
                    lista.add(desempenho);
                
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }finally{
            this.pool.devolveConexao(conexao);
            this.conexao = null;
        }
        
       return lista;
    }
     
    
}
