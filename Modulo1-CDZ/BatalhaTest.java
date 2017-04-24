import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
   @Test
   public void aoIniciarBatalhaDeSaintsComCategoriasDeArmaduraIguaisSaint2DevePerderVida() throws Exception {
        Saint mirela = new SilverSaint("Mirela", "Virgem");
        mirela.aprenderGolpe(new Golpe("Soco", 25));        
        Saint milo = new SilverSaint("Milo", "Escorpião");
        milo.aprenderGolpe(new Golpe("Rasteira", 10));
        
        Movimento mirelaMovimento1 = new VestirArmadura(mirela);
        Movimento mirelaMovimento2 = new Golpear(mirela, milo);

        mirela.adicionarMovimento(mirelaMovimento1);
        mirela.adicionarMovimento(mirelaMovimento2);
       
        Movimento miloMovimento1 = new Golpear(milo, mirela);
        milo.adicionarMovimento(miloMovimento1);
        
        Batalha batalha = new Batalha(mirela, milo);
        batalha.iniciar();
        assertEquals(0, milo.getVida(), 0);
        assertEquals(70, mirela.getVida(), 0);
    }
    
    @Test
    public void primeiroSaintComCategoriaInferiorDevePerderVida() throws Exception {
        Saint shaka = new BronzeSaint("Shaka", "Virgem");
        shaka.aprenderGolpe(new Golpe("Soco", 25)); 
        
        Saint milo = new GoldSaint("Milo", "Escorpião");
        milo.aprenderGolpe(new Golpe("Rasteira", 10));
        
        Movimento shakaMovimento1 = new VestirArmadura(shaka);
        Movimento shakaMovimento2 = new Golpear(shaka, milo);

        shaka.adicionarMovimento(shakaMovimento1);
        shaka.adicionarMovimento(shakaMovimento2);
       
        Movimento miloMovimento1 = new Golpear(milo, shaka);
        milo.adicionarMovimento(miloMovimento1);
        
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        assertEquals(0, milo.getVida(), 0);
        assertEquals(60, shaka.getVida(), 0);
    }
    
    @Test
    public void segundoSaintComCategoriaInferiorDevePerderVida() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        shaka.aprenderGolpe(new Golpe("Soco", 25));
        Saint milo = new BronzeSaint("Milo", "Escorpião");
        milo.aprenderGolpe(new Golpe("Rasteira", 10));
        
        Movimento shakaMovimento1 = new VestirArmadura(shaka);
        Movimento shakaMovimento2 = new Golpear(shaka, milo);
        shaka.adicionarMovimento(shakaMovimento1);
        shaka.adicionarMovimento(shakaMovimento2);
       
        Movimento miloMovimento1 = new Golpear(milo, shaka);
        milo.adicionarMovimento(miloMovimento1);
        
        Batalha batalha = new Batalha(shaka, milo);
        batalha.iniciar();
        assertEquals(0, milo.getVida(), 0);
        assertEquals(90, shaka.getVida(), 0);
    }
    
}