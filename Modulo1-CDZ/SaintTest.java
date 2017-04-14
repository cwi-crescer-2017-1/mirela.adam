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
        assertEquals(StatusVida.VIVO, shaka.getStatusVida());
    
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
}
