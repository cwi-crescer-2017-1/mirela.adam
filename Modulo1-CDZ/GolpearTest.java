import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest {
    @Test
    public void saintDeBronzeSemArmaduraMantemFatorDanoDoGolpe() throws Exception{
        Golpe chute = new Golpe("Chute", 5);
        Golpe soco = new Golpe("Soco", 8);
        Golpe rasteira = new Golpe("Rasteira", 2);
        Saint mirela = new BronzeSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.getConstelacao().adicionarGolpe(rasteira);

        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();

        assertEquals(100, mirela.getVida(), 0);
        assertEquals(95, tales.getVida(), 0);        
    }

    @Test
    public void saintDeBronzeComArmaduraMultiplicaFatorDanoDoGolpePorDois() throws Exception{
        Golpe chute = new Golpe("Chute", 5);
        Saint mirela = new BronzeSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.vestirArmadura();
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();

        assertEquals(100, mirela.getVida(), 0);
        assertEquals(90, tales.getVida(), 0);        
    }

    @Test
    public void saintDePrataSemArmaduraMantemFatorDanoDoGolpe() throws Exception{
        Golpe rasteira = new Golpe("Rasteira", 2);
        Saint mirela = new SilverSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(rasteira);
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();

        assertEquals(100, mirela.getVida(), 0);
        assertEquals(98, tales.getVida(), 0);        
    }

    @Test
    public void saintDePrataComArmaduraMultiplicaFatorDanoDoGolpePorTres() throws Exception{
        Golpe soco = new Golpe("Soco", 8);
        Saint mirela = new SilverSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(soco); 
        mirela.vestirArmadura();
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();

        assertEquals(100, mirela.getVida(), 0);
        assertEquals(76, tales.getVida(), 0);        
    }

    @Test
    public void saintDeOuroSemArmaduraMantemFatorDanoDoGolpe() throws Exception{
        Golpe soco = new Golpe("Soco", 8);
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(soco);
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();

        assertEquals(100, mirela.getVida(), 0);
        assertEquals(92, tales.getVida(), 0);        
    }

    @Test
    public void saintDeOuroComArmaduraMultiplicaFatorDanoDoGolpePorQuatro() throws Exception{
        Golpe chute = new Golpe("Chute", 5);
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.vestirArmadura();
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();

        assertEquals(100, mirela.getVida(), 0);
        assertEquals(80, tales.getVida(), 0);        
    }
}
