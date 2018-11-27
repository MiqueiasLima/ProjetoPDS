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
import model.Time;

/**
 *
 * @author jose
 */
public class DaoTime implements Dao {

    private ConnectionPool pool;
    private Conexao conexao;

    public DaoTime() {

        this.pool = new ConnectionPool("jdbc:mysql://localhost:3306/mydb", "root", "Senha", "com.mysql.jdbc.Driver");

    }

    @Override
    public boolean inserir(Object object) {

        Time time = (Time) object;

        this.conexao = this.pool.getConnection();
        String sql = "INSERT INTO time (nome) VALUES (?)";

        try {

            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setString(1, time.getNome());
            this.conexao.getStmt().execute();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;

        } finally {
            
            this.pool.devolveConexao(conexao);
            conexao = null;

        }

        
    }

    @Override
    public boolean excluir(Object object) {
        this.conexao=this.pool.getConnection();
        
        Time time = (Time) object;
        String sql ="DELETE FROM time WHERE id=?";
        
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1, time.getId());
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
    public boolean atualizar(Object object) {
        Time time = (Time)object;
        String sql="UPDATE  time SET nome=? WHERE id=?";
        this.conexao=this.pool.getConnection();
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setString(1, time.getNome());
            this.conexao.getStmt().setInt(2, time.getId());
            this.conexao.getStmt().executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro"+ex);
            return false;
        }finally{
            
            this.pool.devolveConexao(conexao);
            this.conexao=null;
            
        }
        
    }

    @Override
    public List buscar() {
       this.conexao=this.pool.getConnection();
       String sql="SELECT * from time";
       ArrayList <Time> lista = new ArrayList<>();
        try {
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
           
            while (this.conexao.getRs().next()){
                
                Time time = new Time();
                
                time.setId(this.conexao.getRs().getInt("id"));
                time.setNome(this.conexao.getRs().getString("nome"));
                lista.add(time);
            
            }
            
        } catch (SQLException ex) {
           
            System.err.println("erro:"+ex);
           
        }finally{
            
            this.pool.devolveConexao(conexao);
            this.conexao=null;
        }
     return lista;  
    }

}
