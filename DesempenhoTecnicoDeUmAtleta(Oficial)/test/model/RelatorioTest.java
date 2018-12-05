/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.itextpdf.text.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class RelatorioTest {
    
    public RelatorioTest() {
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
     * Test of templateMethod method, of class Relatorio.
     */
    @Test
    public void testTemplateMethod() {
        System.out.println("templateMethod");
        Relatorio instance = new RelatorioImpl();
        instance.templateMethod();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of corpo method, of class Relatorio.
     */
    @Test
    public void testCorpo() {
        System.out.println("corpo");
        Document documento = null;
        Relatorio instance = new RelatorioImpl();
        Document expResult = null;
        Document result = instance.corpo(documento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rodaPe method, of class Relatorio.
     */
    @Test
    public void testRodaPe() {
        System.out.println("rodaPe");
        Document documento = null;
        Relatorio instance = new RelatorioImpl();
        Document expResult = null;
        Document result = instance.rodaPe(documento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class Relatorio.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        Relatorio instance = new RelatorioImpl();
        Time expResult = null;
        Time result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTime method, of class Relatorio.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        Time time = null;
        Relatorio instance = new RelatorioImpl();
        instance.setTime(time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class RelatorioImpl extends Relatorio {

        public Document corpo(Document documento) {
            return null;
        }

        public Document rodaPe(Document documento) {
            return null;
        }
    }
    
}
