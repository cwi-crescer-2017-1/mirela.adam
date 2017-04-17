import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida(){
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado(){
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test 
    public void aoCriarSaintStatusDaVidaEVivo(){
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        assertEquals(Status.VIVO, shaka.getStatus());
    
    }
    
    @Test
    public void aoCriarSaintQuantidadeVidaEIgualACem(){
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        assertEquals(100, shaka.getVidaAtual(), 0);
    }
    
    @Test
    public void perderVidaSubtraiValorDoParametroDoAtributoVidaAtualDoSaint(){
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        shaka.perderVida(8);
        assertEquals(92, shaka.getVidaAtual(), 0);
    }
    
    @Test
    public void perderVidaSubtraiVidaAtualDeCadaSaintCriadoQueInvocarOMetodo(){
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        Armadura cisne =  new Armadura("Cisne", Categoria.BRONZE);
        Saint hyoga = new Saint("Hyoga", cisne);
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        
        shaka.perderVida(90);
        hyoga.perderVida(18);
        milo.perderVida(77);
       
        assertEquals(10, shaka.getVidaAtual(), 0);
        assertEquals(82, hyoga.getVidaAtual(), 0);
        assertEquals(23, milo.getVidaAtual(), 0);
    }
    
    @Test
    public void saintDeveTerPontosDeVidaSubtraidosACadaChamadaDoMetodoPerderVida(){
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        
        shaka.perderVida(10);
        assertEquals(90, shaka.getVidaAtual(), 0);
        shaka.perderVida(22);
        assertEquals(68, shaka.getVidaAtual(), 0);
        shaka.perderVida(18);
        assertEquals(50, shaka.getVidaAtual(), 0);
        shaka.perderVida(33);
        assertEquals(17, shaka.getVidaAtual(), 0);
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero(){
        Saint jabu = new Saint("Jabu", new Armadura("Unicórnio", Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }
    
    
}
