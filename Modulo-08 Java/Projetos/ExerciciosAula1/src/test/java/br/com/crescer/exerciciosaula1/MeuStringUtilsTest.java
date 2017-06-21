/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exerciciosaula1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirela
 */
public class MeuStringUtilsTest {
    
    public MeuStringUtilsTest() {
    }
    /**
     * Test of isEmpty method, of class MeuStringUtils.
     */
    @org.junit.Test
    public void testIsEmpty() {
        String string = "";
        MeuStringUtils instance = new MeuStringUtils();
        boolean expResult = true;
        boolean result = instance.isEmpty(string);
        assertTrue(instance.isEmpty(string));
    }
    
    @org.junit.Test
    public void testIsNull() {
        String string = null;
        MeuStringUtils instance = new MeuStringUtils();
        assertTrue(instance.isEmpty(string));
    }
    
    @org.junit.Test
    public void testIsNullRetornaFalso() {
        String string = "Teste";
        MeuStringUtils instance = new MeuStringUtils();
        assertFalse(instance.isEmpty(string));
    }

    /**
     * Test of inverter method, of class MeuStringUtils.
     */
    @org.junit.Test
    public void testInverter() {
        String string = "abc";
        MeuStringUtils instance = new MeuStringUtils();
        assertEquals("cba", instance.inverter(string));
    }

    /**
     * Test of contaVogais method, of class MeuStringUtils.
     */
    @org.junit.Test
    public void testContaVogaisPalavraComLetrasMinusculas() {
        String string = "testando";
        MeuStringUtils instance = new MeuStringUtils();
        assertEquals(3, instance.contaVogais(string));
    }
    @org.junit.Test
    public void testContaVogaisPalavraComLetrasMaiusculas() {
        String string = "PARALELEPIPEDO";
        MeuStringUtils instance = new MeuStringUtils();
        assertEquals(7, instance.contaVogais(string));
    }
    
    @org.junit.Test
    public void testContaVogaisPalavraComLetrasMaiusculasEMinusculas() {
        String string = "Letras MAIUscuLAs";
        MeuStringUtils instance = new MeuStringUtils();
        assertEquals(7, instance.contaVogais(string));
    }
    
    @org.junit.Test
     public void testContaVogaisPalavraComAcentos() {
        String string = "Letras MAIúscuLAs AcentuAÇÃo";
        MeuStringUtils instance = new MeuStringUtils();
        assertEquals(13, instance.contaVogais(string));
    }
    
    /**
     * Test of isPalindromo method, of class MeuStringUtils.
     */
    @org.junit.Test
    public void testIsPalindromoAmeAEma() {
        String string = "Ame a ema";
        MeuStringUtils instance = new MeuStringUtils();
        assertTrue(instance.isPalindromo(string));
    }
    
    @org.junit.Test
    public void testIsPalindromoASograMaEAmargosa() {
        String string = "A sogra má e amargosa";
        MeuStringUtils instance = new MeuStringUtils();
        assertTrue(instance.isPalindromo(string));
    }
    
    @org.junit.Test
    public void testIsPalindromoOvo() {
        String string = "ovo";
        MeuStringUtils instance = new MeuStringUtils();
        assertTrue(instance.isPalindromo(string));
    }
    
    @org.junit.Test
    public void testIsPalindromoRetornaFalseQuandoNaoEhPalindromo() {
        String string = "Oi tudo bem";
        MeuStringUtils instance = new MeuStringUtils();
        assertFalse(instance.isPalindromo(string));
    }
    
}
