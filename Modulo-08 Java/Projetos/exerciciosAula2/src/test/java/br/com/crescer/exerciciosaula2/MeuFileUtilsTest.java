package br.com.crescer.exerciciosaula2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Mirela
 */
public class MeuFileUtilsTest {
    public MeuFileUtilsTest() {}
    /**
     * Test of mk method, of class MeuFileUtils.
     */
    @Test
    public void testMkCriaArquivo() {
        MeuFileUtils mfu = new MeuFileUtils();
        assertTrue(mfu.mk("TesteCriacao.txt"));
        mfu.rm("TesteCriacao.txt");
    }
    
    @Test
    public void testMkCriaDiretorio() {
        MeuFileUtils mfu = new MeuFileUtils();
        assertTrue(mfu.mk("TesteCriacaoDiretorio"));
    }
    
    @Test
    public void testMkInvalido() {
        MeuFileUtils mfu = new MeuFileUtils();
        assertFalse(mfu.mk("&*&((&.DSAD@##"));
    }
    /**
     * Test of rm method, of class MeuFileUtils.
     */
    @Test
    public void testRmExcluirArquivoExistente() {
        MeuFileUtils mfu = new MeuFileUtils();
        mfu.mk("excluir.txt");
        assertTrue(mfu.rm("excluir.txt"));
    }
    
    @Test
    public void testRmExcluirArquivoInexistente() {
        MeuFileUtils mfu = new MeuFileUtils();
        assertFalse(mfu.rm("naoExiste.txt"));
    }
    
    @Test
    public void testRmComDiretorioRetornaFalso() throws Exception {
        MeuFileUtils mfu = new MeuFileUtils();
        assertFalse(mfu.rm("pasta1"));
    }
    
    @Test
    public void testRmComArquivoInexistenteRetornaFalso() throws Exception {
        MeuFileUtils mfu = new MeuFileUtils();
        assertFalse(mfu.rm("pasta1.txt"));
    }

    /**
     * Test of ls method, of class MeuFileUtils.
     */
    @Test
    public void testLsComDiretorioDeveListarDocumentosInternos() {
        MeuFileUtils mfu = new MeuFileUtils();
        assertEquals("[MaisUm.txt, Teste.txt, TesteDoc.doc]", mfu.ls(".\\pasta1"));
    }

    /**
     * Test of mv method, of class MeuFileUtils.
     */
    @Test
    public void testMv() {
        MeuFileUtils mfu = new MeuFileUtils();
        //criar o arquivo
        assertTrue(mfu.mk("TesteMover.txt"));
        //verifica se criou na raiz do projeto
        assertTrue(mfu.ls(".").contains("TesteMover.txt"));
        //move para a pasta2
        mfu.mv("TesteMover.txt", ".\\pasta2");
        //verifica se esta na pasta2
        assertEquals("[TesteMover.txt]", mfu.ls(".\\pasta2"));
        //verifica se deixou de existir na raiz do projeto
        assertFalse(mfu.ls(".").contains("TesteMover.txt"));
        //remove o arquivo da pasta2 para nao gerar conflito nos proximos testes
        mfu.rm(".\\pasta2\\TesteMover.txt");
        //verifica se foi excluido da pasta2
        assertFalse(mfu.ls(".\\pasta2").contains("TesteMover.txt"));
    }   
    
    @Test
    public void testMvPassandoDiretorioRetornaFalso() {
        MeuFileUtils mfu = new MeuFileUtils();
        assertFalse(mfu.mv(".\\pasta2", ".\\pasta1"));
    }
}
