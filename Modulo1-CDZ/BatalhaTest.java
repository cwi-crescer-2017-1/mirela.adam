import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
   @Test
   public void aoIniciarBatalhaDeSaintsComCategoriasDeArmaduraIguaisSaint2DevePerderVida() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        
        Armadura escorpiao = new Armadura(new Constelacao("Escorpião"), Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        
        assertEquals(90, milo.getVida(), 0);
        assertEquals(100, shaka.getVida(), 0);
    }
    
    @Test
    public void primeiroSaintComCategoriaInferiorDevePerderVida() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.BRONZE);
        Saint shaka = new Saint("Shaka", virgem);
        
        Armadura escorpiao = new Armadura(new Constelacao("Escorpião"), Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        
        assertEquals(90, shaka.getVida(), 0);
        assertEquals(100, milo.getVida(), 0);
    }
    
    @Test
    public void segundoSaintComCategoriaInferiorDevePerderVida() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.PRATA);
        Saint shaka = new Saint("Shaka", virgem);
        
        Armadura escorpiao = new Armadura(new Constelacao("Escorpião"), Categoria.BRONZE);
        Saint milo = new Saint("Milo", escorpiao);
        
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        
        assertEquals(90, milo.getVida(), 0);
        assertEquals(100, shaka.getVida(), 0);
    }
}
