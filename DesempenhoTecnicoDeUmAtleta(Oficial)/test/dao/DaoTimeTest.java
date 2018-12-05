/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import java.util.List;
import model.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author jose
 */
public class DaoTimeTest {
    
    public DaoTimeTest() {
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
     * Test of inserir method, of class DaoTime.
     */
    @Test
    @Ignore
    public void testInserir() {

       Time time = new Time();
       time.setNome("Hello");
       DaoTime dbt= new DaoTime();
       
       dbt.inserir(time);
       
    }
    

    /**
     * Test of excluir method, of class DaoTime.
     */
    @Test
    @Ignore
    public void testExcluir() {
       Time time = new Time();
       time.setNome("São Paulo");
       time.setId(3);
       DaoTime dbt= new DaoTime();
       
       dbt.excluir(time);

        
    }

    /**
     * Test of atualizar method, of class DaoTime.
     */
    @Test
    @Ignore
    public void testAtualizar() {
        Time time = new Time();
       time.setNome("São Paulo");
       time.setId(4);
       DaoTime dbt= new DaoTime();
       
       dbt.atualizar(time);
    }

    /**
     * Test of buscar method, of class DaoTime.
     */
    @Test
    public void testBuscar() {
        DaoTime timeDb = new DaoTime();
        ArrayList <Time> lista = new ArrayList <>();
        
        lista = (ArrayList<Time>) timeDb.buscar();
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        
    }
    
}
