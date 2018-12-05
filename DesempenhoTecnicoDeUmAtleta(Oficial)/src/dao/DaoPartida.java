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

import model.Partida;

/**
 *
 * @author jose
 */
public class DaoPartida implements Dao{
    
    
    private ConnectionPool pool;
    private Conexao conexao;
    
    public DaoPartida(){
        this.pool=new ConnectionPool("jdbc:mysql://localhost:3306/mydb", "root", "peken", "com.mysql.jdbc.Driver");
    }
    
    @Override
    public boolean inserir(Object object) {
        Partida partida = (Partida) object;
        
        this.conexao=this.pool.getConnection();
        String sql = "INSERT INTO partida (timeCasa,timeFora,resultado,tipoDeJogo,horario,localPartida,data) VALUES (?,?,?,?,?,?,?)";
        
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setString(1, partida.getTimeCasa());
            this.conexao.getStmt().setString(2, partida.getTimeFora());
            this.conexao.getStmt().setString(3, partida.getResultado());
            this.conexao.getStmt().setString(4, partida.getTipoDeJogo());
            this.conexao.getStmt().setString(5, partida.getHorario());
            this.conexao.getStmt().setString(6, partida.getLocalDaPartida());
            this.conexao.getStmt().setString(7, partida.getData());
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
    public boolean excluir(Object object) {
       Partida partida = (Partida) object;
        
        this.conexao=this.pool.getConnection();
        String sql = "DELETE FROM partida WHERE id=?";
        
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1, partida.getId());
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
       Partida partida =(Partida) object;
       
       this.conexao=this.pool.getConnection();
       String sql="UPDATE partida SET timeCasa=?,timeFora=?,resultado=?,tipoDejogo=?,horario=?,localPartida=?,data=? WHERE id=?";
       
        try {
            
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setString(1,partida.getTimeCasa() );
            this.conexao.getStmt().setString(2,partida.getTimeFora() );
            this.conexao.getStmt().setString(3,partida.getResultado() );
            this.conexao.getStmt().setString(4,partida.getTipoDeJogo());
            this.conexao.getStmt().setString(5,partida.getHorario());
            this.conexao.getStmt().setString(6, partida.getLocalDaPartida());
            this.conexao.getStmt().setString(7, partida.getData());
            this.conexao.getStmt().setInt(8, partida.getId());
            this.conexao.getStmt().executeUpdate();
            return true;
            
                    
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        }finally{
            
            this.pool.devolveConexao(conexao);
            conexao=null;
        }
        
    }

    @Override
    public List buscar() {
       this.conexao=this.pool.getConnection();
       ArrayList<Partida> lista= new ArrayList<>();
       String sql = "SELECT * FROM partida";
       
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
                
                Partida partida = new Partida();
                
                partida.setData(this.conexao.getRs().getString("data"));
                partida.setHorario(this.conexao.getRs().getString("horario"));
                partida.setResultado(this.conexao.getRs().getString("resultado"));
                partida.setTimeCasa(this.conexao.getRs().getString("timeCasa"));
                partida.setTimeFora(this.conexao.getRs().getString("timeFora"));
                partida.setTipoDeJogo(this.conexao.getRs().getString("tipoDeJogo"));
                partida.setLocalDaPartida(this.conexao.getRs().getString("localPartida"));
                partida.setId(this.conexao.getRs().getInt("id"));
                lista.add(partida);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }finally{
            this.pool.devolveConexao(conexao);
            this.conexao=null;
        }
       
       
       
       return lista;
    }
    public List buscarNomePartida() {
       this.conexao=this.pool.getConnection();
       ArrayList<Partida> lista= new ArrayList<>();
       String sql = "SELECT id, FROM partida";
       
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            while(this.conexao.getRs().next()){
                
                Partida partida = new Partida();
                
                partida.setData(this.conexao.getRs().getString("data"));
                partida.setHorario(this.conexao.getRs().getString("horario"));
                partida.setResultado(this.conexao.getRs().getString("resultado"));
                partida.setTimeCasa(this.conexao.getRs().getString("timeCasa"));
                partida.setTimeFora(this.conexao.getRs().getString("timeFora"));
                partida.setTipoDeJogo(this.conexao.getRs().getString("tipoDeJogo"));
                partida.setLocalDaPartida(this.conexao.getRs().getString("localPartida"));
                partida.setId(this.conexao.getRs().getInt("id"));
                lista.add(partida);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }finally{
            this.pool.devolveConexao(conexao);
            this.conexao=null;
        }
       
       
       
       return lista;
    }
    
}
