import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
   @Test
   public void aoIniciarBatalhaDeSaintsComCategoriasDeArmaduraIguaisSaint2DevePerderVida() throws Exception {
        Saint shaka = new SilverSaint("Shaka", "Virgem");
        Saint milo = new BronzeSaint("Milo", "Escorpião");
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        assertEquals(90, milo.getVida(), 0);
        assertEquals(100, shaka.getVida(), 0);
    }
    
    @Test
    public void primeiroSaintComCategoriaInferiorDevePerderVida() throws Exception {
        Saint shaka = new BronzeSaint("Shaka", "Virgem");
        Saint milo = new GoldSaint("Milo", "Escorpião");
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        assertEquals(90, shaka.getVida(), 0);
        assertEquals(100, milo.getVida(), 0);
    }
    
    @Test
    public void segundoSaintComCategoriaInferiorDevePerderVida() throws Exception {
        Saint shaka = new SilverSaint("Shaka", "Virgem");
        Saint milo = new BronzeSaint("Milo", "Escorpião");
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        assertEquals(90, milo.getVida(), 0);
        assertEquals(100, shaka.getVida(), 0);
    }
}
