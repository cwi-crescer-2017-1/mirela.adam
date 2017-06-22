package br.com.crescer.exerciciosaula2;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Mirela
 */
public class MeuWriterUtilsTest {
    
    public MeuWriterUtilsTest() {
    }
    
    /**
     * Test of write method, of class MeuWriterUtils.
     */
    @Test
    public void testWrite() throws Exception {
        MeuWriterUtils w = new MeuWriterUtils();
        MeuReaderUtils r = new MeuReaderUtils();
        MeuFileUtils f = new MeuFileUtils();
        f.rm("write.txt");
        f.mk("write.txt");
        w.write("write.txt", "Teste oi tudo writing");
        assertEquals("Teste oi tudo writing\n", r.read("write.txt"));
    }
    
    @Test(expected=Exception.class)
    public void testWriteArquivoInexistenteLancaException() throws Exception {
        MeuWriterUtils m = new MeuWriterUtils();
        m.write(".\\pasta1\\NAOEXISTE.txt","Hello");
    }
    
    @Test(expected=Exception.class)
    public void testWriteArquivoQueNaoEhTxtLancaException() throws Exception {
        MeuWriterUtils m = new MeuWriterUtils();
        m.write(".\\pasta1\\NAOEXISTE.doc","DOCDOCDOC");
    }
    
}
