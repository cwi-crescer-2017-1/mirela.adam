package br.com.crescer.exerciciosaula2;

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
public class MeuReaderUtilsTest {
    
    public MeuReaderUtilsTest() {
    }
     /**
     * Test of read method, of class MeuReaderUtils.
     */
    @Test
    public void testReadArquivoExistente() throws Exception {
        MeuReaderUtils m = new MeuReaderUtils();
        assertEquals("oioioi\ntudo\nbem com\nvoce\n", m.read(".\\pasta1\\Teste.txt"));
    }
    
    @Test(expected=Exception.class)
    public void testReadArquivoInexistenteLancaException() throws Exception {
        MeuReaderUtils m = new MeuReaderUtils();
        m.read(".\\pasta1\\NAOEXISTE.txt");
    }
    
    @Test(expected=Exception.class)
    public void testReadArquivoQueNaoEhTxtLancaException() throws Exception {
        MeuReaderUtils m = new MeuReaderUtils();
        m.read(".\\pasta1\\NAOEXISTE.doc");
    }
    
}
