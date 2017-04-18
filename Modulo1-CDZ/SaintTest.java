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
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new GoldSaint("Milo", escorpiao);
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test 
    public void aoCriarSaintStatusDaVidaEVivo() throws Exception {
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(Status.VIVO, shaka.getStatus());
    
    }
    
    @Test
    public void aoCriarSaintQuantidadeVidaEIgualACem() throws Exception {
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(100, shaka.getVida(), 0);
    }
    
    @Test
    public void perderVidaSubtraiValorDoParametroDoAtributoVidaAtualDoSaint() throws Exception {
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(8);
        assertEquals(92, shaka.getVida(), 0);
    }
    
    @Test
    public void perderVidaSubtraiVidaAtualDeCadaSaintCriadoQueInvocarOMetodo() throws Exception {
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        Armadura cisne =  new Armadura("Cisne", Categoria.BRONZE);
        Saint hyoga = new BronzeSaint("Hyoga", cisne);
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
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
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
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
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(100);
        assertEquals(0, shaka.getVida(), 0);
    }
    
    @Test
    public void perderDanoComValor1000() throws Exception {
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(1000);
        assertEquals(0, shaka.getVida(), 0);
    }
    
    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorMenos1000() throws Exception {
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(-1000);
        assertEquals(1100, shaka.getVida(), 0);
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new BronzeSaint("Jabu", new Armadura("Unicórnio", Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }  
    
    @Test
    public void criarSaintBronzeNasceCom5SentidosDespertados() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        Saint seiya = new SilverSaint("Seiya", new Armadura("Pégaso", Categoria.PRATA));
        assertEquals(6, seiya.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        Saint seiya = new GoldSaint("Seiya", new Armadura("Escorpião", Categoria.OURO));
        assertEquals(7, seiya.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Mirela", new Armadura("Café", Categoria.OURO));
    }
    
    @Test
    public void alteraStatusParaMortoSeVidaMenorQueUm() throws Exception{
        Saint mirela = new GoldSaint("Mirela", new Armadura("Escorpião", Categoria.OURO));
        mirela.perderVida(110);
        assertEquals(Status.MORTO, mirela.getStatus());
    }
    
    
}
