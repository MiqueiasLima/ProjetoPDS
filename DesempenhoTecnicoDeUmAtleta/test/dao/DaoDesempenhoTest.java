/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Desempenho;
import model.Jogador;
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
public class DaoDesempenhoTest {

    public DaoDesempenhoTest() {
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
     * Test of inserir method, of class DaoDesempenho.
     */
    @Test
    @Ignore
    public void testInserir() {
        Jogador jogador = new Jogador();
        jogador.setId(3);
        Partida partida = new Partida();
        partida.setId(2);
        Desempenho desempenho = new Desempenho();
        DaoDesempenho db = new DaoDesempenho();

        desempenho.setAssistencia(1);
        desempenho.setDesarme(32);
        desempenho.setDominioCerto(100);
        desempenho.setDominioErrado(233);
        desempenho.setDominioTotal(100);
        desempenho.setDrible(23);
        desempenho.setFinalizacoesGols(4);
        desempenho.setFinalizacoesTotais(10);
        desempenho.setGol(23);
        desempenho.setJogador(jogador);
        desempenho.setTotalDePasses(35);
        desempenho.setPartida(partida);
        desempenho.setPassesCertos(13);
        desempenho.setPassesErrados(23);

        db.inserir(desempenho);

    }

    /**
     * Test of excluir method, of class DaoDesempenho.
     */
    @Test
    public void testExcluir() {
        DaoDesempenho dao= new DaoDesempenho();
        Desempenho desempenho = new Desempenho();
        desempenho.setId(3);
        dao.excluir(desempenho);
        

    }

    /**
     * Test of atualizar method, of class DaoDesempenho.
     */
    @Test
    @Ignore
    public void testAtualizar() {
        Jogador jogador = new Jogador();
        jogador.setId(3);
        Partida partida = new Partida();
        partida.setId(2);
        Desempenho desempenho = new Desempenho();
        DaoDesempenho db = new DaoDesempenho();

        desempenho.setId(3);
        desempenho.setAssistencia(1);
        desempenho.setDesarme(32);
        desempenho.setDominioCerto(100);
        desempenho.setDominioErrado(233);
        desempenho.setDominioTotal(100);
        desempenho.setDrible(23);
        desempenho.setFinalizacoesGols(200);
        desempenho.setFinalizacoesTotais(10);
        desempenho.setGol(23);
        desempenho.setJogador(jogador);
        desempenho.setTotalDePasses(35);
        desempenho.setPartida(partida);
        desempenho.setPassesCertos(13);
        desempenho.setPassesErrados(23);

        db.atualizar(desempenho);

    }

    /**
     * Test of buscar method, of class DaoDesempenho.
     */
    @Test
    @Ignore
    public void testBuscar() {

        ArrayList lista = new ArrayList();

        DaoDesempenho desempenho = new DaoDesempenho();
        lista = (ArrayList) desempenho.buscar();
        for (int i = 0; i < lista.size(); i++) {

            System.out.println(lista.get(i));
        }

    }

}
