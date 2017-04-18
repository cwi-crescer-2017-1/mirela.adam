import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException; 

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Constelacao escorpiao = new Constelacao("Escorpião");
        Armadura armaduraEscorpiao = new Armadura(escorpiao, Categoria.OURO);
        Saint milo = new GoldSaint("Milo", armaduraEscorpiao);
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Constelacao cisne = new Constelacao("Cisne");
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(cisne, Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Armadura virgem = new Armadura( new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test 
    public void aoCriarSaintStatusDaVidaEVivo() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(Status.VIVO, shaka.getStatus());
    
    }
    
    @Test
    public void aoCriarSaintQuantidadeVidaEIgualACem() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(100, shaka.getVida(), 0);
    }
    
    @Test
    public void perderVidaSubtraiValorDoParametroDoAtributoVidaAtualDoSaint() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(8);
        assertEquals(92, shaka.getVida(), 0);
    }
    
    @Test
    public void perderVidaSubtraiVidaAtualDeCadaSaintCriadoQueInvocarOMetodo() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        Armadura cisne =  new Armadura(new Constelacao("Cisne"), Categoria.BRONZE);
        Saint hyoga = new BronzeSaint("Hyoga", cisne);
        Armadura escorpiao = new Armadura(new Constelacao("Escorpião"), Categoria.OURO);
        Saint milo = new GoldSaint("Milo", escorpiao);
        
        shaka.perderVida(90);
        hyoga.perderVida(18);
        milo.perderVida(77);
       
        assertEquals(10, shaka.getVida(), 0);
        assertEquals(82, hyoga.getVida(), 0);
        assertEquals(23, milo.getVida(), 0);
    }
    
    @Test
    public void saintDeveTerPontosDeVidaSubtraidosACadaChamadaDoMetodoPerderVida() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        
        shaka.perderVida(10);
        assertEquals(90, shaka.getVida(), 0);
        shaka.perderVida(22);
        assertEquals(68, shaka.getVida(), 0);
        shaka.perderVida(18);
        assertEquals(50, shaka.getVida(), 0);
        shaka.perderVida(33);
        assertEquals(17, shaka.getVida(), 0);
    }
    
    @Test
    public void perderDanoComValor100() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(100);
        assertEquals(0, shaka.getVida(), 0);
    }
    
    @Test
    public void perderDanoComValor1000() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(1000);
        assertEquals(0, shaka.getVida(), 0);
    }
    
    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorMenos1000() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(-1000);
        assertEquals(1100, shaka.getVida(), 0);
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new BronzeSaint("Jabu", new Armadura(new Constelacao("Unicórnio"), Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }  
    
    @Test
    public void criarSaintBronzeNasceCom5SentidosDespertados() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        Saint seiya = new SilverSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        assertEquals(6, seiya.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        Saint seiya = new GoldSaint("Seiya", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        assertEquals(7, seiya.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Mirela", new Armadura(new Constelacao("Café"), Categoria.OURO));
    }
    
    @Test
    public void alteraStatusParaMortoSeVidaMenorQueUm() throws Exception {
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        mirela.perderVida(110);
        assertEquals(Status.MORTO, mirela.getStatus());
    }
    
    @Test
    public void verificaMetodoGetGolpesDoSaintComTresGolpes() throws Exception {
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Chute", 13));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Soco", 15));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Rasteira", 12));
        
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        
        assertEquals("Chute", mirela.getGolpes()[0].getNome());
        assertEquals("Soco", mirela.getGolpes()[1].getNome());
        assertEquals("Rasteira", mirela.getGolpes()[2].getNome());
        
    }
    
    @Test
    public void verificaMetodoGetGolpesDoSaintComDoisGolpes() throws Exception {
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Chute", 13));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Soco", 15));        
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        
        assertEquals("Chute", mirela.getGolpes()[0].getNome());
        assertEquals("Soco", mirela.getGolpes()[1].getNome());
        assertEquals(null, mirela.getGolpes()[2]);
        
    }
    
    @Test
    public void verificaMetodoGetGolpesDoSaintComUmGolpe() throws Exception {
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Chute", 13));
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        
        assertEquals("Chute", mirela.getGolpes()[0].getNome());
        assertEquals(null, mirela.getGolpes()[1]);
        assertEquals(null, mirela.getGolpes()[2]);
        
    }
    
    @Test
    public void insereGolpeNaConstelacaoDoSaint() throws Exception {
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        
        mirela.aprenderGolpe(new Golpe("Narizada",19));
        mirela.aprenderGolpe(new Golpe("Testada",20));
        mirela.aprenderGolpe(new Golpe("Joelhada",15));
        
        assertEquals("Narizada", mirela.getGolpes()[0].getNome());
        assertEquals("Testada", mirela.getGolpes()[1].getNome());
        assertEquals("Joelhada", mirela.getGolpes()[2].getNome());
    
    }  
    
    @Test(expected=Exception.class)
    public void inserirMaisDeTresGolpesNaConstelacaoDoSaintDeveLancarException() throws Exception {
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        mirela.aprenderGolpe(new Golpe("Narizada",19));
        mirela.aprenderGolpe(new Golpe("Testada",20));
        mirela.aprenderGolpe(new Golpe("Joelhada",15));
        mirela.aprenderGolpe(new Golpe("Unhada",15));
    }
    
    @Test
    public void verificaMetodoProximoGolpeQuandoPossuiTresGolpes() throws Exception {
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        mirela.aprenderGolpe(new Golpe("Narizada",19));
        mirela.aprenderGolpe(new Golpe("Testada",20));
        mirela.aprenderGolpe(new Golpe("Joelhada",15));
        
        assertEquals("Narizada", mirela.getProximoGolpe().getNome());
        assertEquals("Testada", mirela.getProximoGolpe().getNome());
        assertEquals("Joelhada", mirela.getProximoGolpe().getNome());
        assertEquals("Narizada", mirela.getProximoGolpe().getNome());
    }
    
    @Test
    public void verificaMetodoProximoGolpeQuandoPossuiDoisGolpes() throws Exception {
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        mirela.aprenderGolpe(new Golpe("Narizada",19));
        mirela.aprenderGolpe(new Golpe("Testada",20));
        
        assertEquals("Narizada", mirela.getProximoGolpe().getNome());
        assertEquals("Testada", mirela.getProximoGolpe().getNome());
        assertEquals("Narizada", mirela.getProximoGolpe().getNome());
        assertEquals("Testada", mirela.getProximoGolpe().getNome());
    }
    
    @Test
    public void verificaMetodoProximoGolpeQuandoPossuiUmGolpe() throws Exception {
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        mirela.aprenderGolpe(new Golpe("Narizada",19));
        
        assertEquals("Narizada", mirela.getProximoGolpe().getNome());
        assertEquals("Narizada", mirela.getProximoGolpe().getNome());
        assertEquals("Narizada", mirela.getProximoGolpe().getNome());
        assertEquals("Narizada", mirela.getProximoGolpe().getNome());
    }
}
