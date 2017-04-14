import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
   @Test
   public void aoIniciarBatalhaDeSaintsComCategoriasDeArmaduraIguaisSaint2DevePerderVida(){
        Armadura virgem = new Armadura("Virgem", Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        
        assertEquals(90, milo.getVidaAtual(), 0);
    }
    
    @Test
    public void saintComCategoriaInferiorDevePerderVida(){
        Armadura virgem = new Armadura("Virgem", Categoria.BRONZE);
        Saint shaka = new Saint("Shaka", virgem);
        
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        
        assertEquals(90, shaka.getVidaAtual(), 0);
    }
}
