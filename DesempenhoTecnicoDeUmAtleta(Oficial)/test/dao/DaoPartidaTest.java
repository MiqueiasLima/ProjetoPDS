/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import model.Partida;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;



/**
 *
 * @author jose
 */
public class DaoPartidaTest {
    
    public DaoPartidaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class DaoPartida.
     */
    @Test
    @Ignore
    public void testInserir() {
        Partida partida = new Partida();
        DaoPartida db= new DaoPartida();
        partida.setData("23/09/2018");
        partida.setHorario("22:00");
        partida.setLocalDaPartida("Morumbi");
        partida.setResultado("2X0");
        partida.setTimeCasa("São Paulo");
        partida.setTimeFora("Palmeiras");
        partida.setTipoDeJogo("Amitoso");
        
        db.inserir(partida);
    }

    /**
     * Test of excluir method, of class DaoPartida.
     */
    @Test
    @Ignore
    public void testExcluir() {
        
         Partida partida = new Partida();
        DaoPartida db= new DaoPartida();
        partida.setId(4);
        
        db.excluir(partida);
        
    }

    /**
     * Test of atualizar method, of class DaoPartida.
     */
    @Test
    
    @Ignore
    public void testAtualizar() {
        
        Partida partida = new Partida();
        DaoPartida db= new DaoPartida();
        partida.setId(2);
        partida.setData("23/09/2018");
        partida.setHorario("22:00");
        partida.setLocalDaPartida("Morumbi");
        partida.setResultado("3X0");
        partida.setTimeCasa("São Paulo");
        partida.setTimeFora("Palmeiras");
        partida.setTipoDeJogo("Amitoso");
        
        db.atualizar(partida);
   
    }

    /**
     * Test of buscar method, of class DaoPartida.
     */
    @Test
    public void testBuscar() {
        
        ArrayList lista = new ArrayList();
        
        DaoPartida partida = new DaoPartida();
        lista=(ArrayList) partida.buscar();
        
        for (Object lista1 : lista) {
            
            System.out.println((Partida)lista1);
        }
        
        
     
    }
    
}
