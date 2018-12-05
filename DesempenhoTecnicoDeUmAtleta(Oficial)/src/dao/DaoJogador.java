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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Desempenho;
import model.Jogador;
import model.Time;

/**
 *
 * @author jose
 */
public class DaoJogador implements Dao {
    
    private ConnectionPool pool;
    private Conexao conexao;
    
    public DaoJogador(){
       this.pool=new ConnectionPool("jdbc:mysql://localhost:3306/db_sport", "root", "peken", "com.mysql.jdbc.Driver");
    }
    
    @Override
    public boolean inserir(Object object) {
       Jogador jogador = (Jogador) object;
    
       this.conexao=this.pool.getConnection();
       String sql="INSERT INTO jogador (nome,dataNascimento,posicao,melhorPe,time_id) VALUES"
               + "(?,?,?,?,?)";
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setString(1, jogador.getNome());
            this.conexao.getStmt().setString(2, jogador.getDataDeNascimento());
            this.conexao.getStmt().setString(3, jogador.getPosicao());
            this.conexao.getStmt().setString(4,String.valueOf(jogador.getMelhor_pe()) );
            this.conexao.getStmt().setInt(5, jogador.getTime().getId());
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
    public boolean excluir(Object object) {
          Jogador jogador = (Jogador) object;
        
        this.conexao=this.pool.getConnection();
        String sql = "DELETE FROM jogador WHERE id=?";
        
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1, jogador.getId());
            this.conexao.getStmt().execute();
            return true;
        } catch (SQLException ex) {
            System.err.print("Erro:"+ex);
            return false;
        }finally{
            this.pool.devolveConexao(conexao);
            conexao=null;
        
        }
        
    }
    

    @Override
    public boolean atualizar(Object object) {
          Jogador jogador = (Jogador) object;
    
       this.conexao=this.pool.getConnection();
       String sql="UPDATE jogador SET nome=?,dataNascimento=?,posicao=?,melhorPe=?,time_id=? WHERE id=? "
               ;
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setString(1, jogador.getNome());
            this.conexao.getStmt().setString(2, jogador.getDataDeNascimento());
            this.conexao.getStmt().setString(3, jogador.getPosicao());
            this.conexao.getStmt().setString(4,String.valueOf(jogador.getMelhor_pe()) );
            this.conexao.getStmt().setInt(5, jogador.getTime().getId());
            this.conexao.getStmt().setInt(6, jogador.getId());
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
    public List buscar() {
       ArrayList<Jogador> lista =new ArrayList<>();
       String sql="SELECT * FROM jogador";
       this.conexao= this.pool.getConnection();
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
                
                Jogador jogador = new Jogador();
           //      nome=?,dataNascimento=?,posicao=?,melhorPe=?,time_id=?
                jogador.setId(this.conexao.getRs().getInt("id"));
                jogador.setNome(this.conexao.getRs().getString("nome"));
                jogador.setDataDeNascimento(this.conexao.getRs().getString("dataNascimento"));
                jogador.setPosicao(this.conexao.getRs().getString("posicao"));
                jogador.setMelhor_pe(this.conexao.getRs().getString("melhorPe").charAt(0));
                
                Time time = new Time ();jogador.setTime(time);
               time.setId(this.conexao.getRs().getInt("time_id"));
               jogador.setTime(time);
               lista.add(jogador);
                
                
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            
        }finally{
            
            this.pool.devolveConexao(conexao);
            conexao=null;
        }
            
        return lista;
     }
    public List buscarNOmeJogador() {
       ArrayList<Jogador> lista =new ArrayList<>();
       String sql="SELECT id,nome FROM jogador";
       this.conexao= this.pool.getConnection();
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
                
                Jogador jogador = new Jogador();
           //      nome=?,dataNascimento=?,posicao=?,melhorPe=?,time_id=?
                jogador.setId(this.conexao.getRs().getInt("id"));
                jogador.setNome(this.conexao.getRs().getString("nome"));
                
                
                
                
               
               lista.add(jogador);
                
                
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            
        }finally{
            
            this.pool.devolveConexao(conexao);
            conexao=null;
        }
            
        return lista;
     }
       public Jogador buscarJogadorPeloId(int id) {
       
       String sql="SELECT * FROM jogador WHERE id=?";
        Jogador jogador = new Jogador();
       this.conexao= this.pool.getConnection();
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1, id);
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
                
               
           //      nome=?,dataNascimento=?,posicao=?,melhorPe=?,time_id=?
                jogador.setId(this.conexao.getRs().getInt("id"));
                jogador.setNome(this.conexao.getRs().getString("nome"));
                jogador.setDataDeNascimento(this.conexao.getRs().getString("dataNascimento"));
                jogador.setPosicao(this.conexao.getRs().getString("posicao"));
                jogador.setMelhor_pe(this.conexao.getRs().getString("melhorPe").charAt(0));
                
                Time time = new Time ();
               time.setId(this.conexao.getRs().getInt("time_id"));
               jogador.setTime(time);
               
                
                
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            
        }finally{
            
            this.pool.devolveConexao(conexao);
            conexao=null;
        }
            
        return jogador;
     }
    
    
}
