/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Jogador;
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
public class DaoJogadorTest {

    public DaoJogadorTest() {
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
     * Test of inserir method, of class DaoJogador.
     */
    @Test
    @Ignore
    public void testInserir() {
        //(nome,dataNascimento,posicao,melhorPe,time_id
        DaoJogador db = new DaoJogador();
        Jogador jg = new Jogador();
        Time time = new Time();
        time.setId(1);
        jg.setNome("Rivaldo");
        jg.setDataDeNascimento("12/1/1980");
        jg.setMelhor_pe('D');
        jg.setPosicao("Ponta-Esquerda");
        jg.setTime(time);
        db.inserir(jg);
    }

    /**
     * Test of excluir method, of class DaoJogador.
     */
    @Test
    public void testExcluir() {

    }

    /**
     * Test of atualizar method, of class DaoJogador.
     */
    @Test
    public void testAtualizar() {
        DaoJogador db = new DaoJogador();
        Jogador jg = new Jogador();
        Time time = new Time();
        time.setId(1);
        jg.setNome("Rivaldo");
        jg.setDataDeNascimento("12/1/1985");
        jg.setMelhor_pe('D');
        jg.setPosicao("Ponta-Esquerda");
        jg.setTime(time);
        jg.setId(4);
        db.atualizar(jg);
    }

    /**
     * Test of buscar method, of class DaoJogador.
     */
    @Test
    public void testBuscar() {
        DaoJogador db= new DaoJogador();
        ArrayList <Jogador> lista= new ArrayList<>();
        lista=(ArrayList<Jogador>) db.buscar();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        

    }

}
