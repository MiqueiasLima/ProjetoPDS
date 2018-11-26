/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionPool.Conexao;
import connectionPool.ConnectionPool;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
