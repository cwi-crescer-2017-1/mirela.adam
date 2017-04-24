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
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(87, tales.getVida(), 0);
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(85, tales.getVida(), 0);
    }

    @Test
    public void saintDeBronzeComArmaduraMultiplicaFatorDanoDoGolpePorDois() throws Exception{
        Golpe chute = new Golpe("Chute", 5);
        Golpe soco = new Golpe("Soco", 8);
        Golpe rasteira = new Golpe("Rasteira", 2);
        Saint mirela = new BronzeSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.getConstelacao().adicionarGolpe(rasteira);
        mirela.vestirArmadura();
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(90, tales.getVida(), 0);      
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(74, tales.getVida(), 0);
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(70, tales.getVida(), 0);
    }

    @Test
    public void saintDePrataSemArmaduraMantemFatorDanoDoGolpe() throws Exception{
        Golpe chute = new Golpe("Chute", 5);
        Golpe soco = new Golpe("Soco", 8);
        Golpe rasteira = new Golpe("Rasteira", 2);
        Saint mirela = new SilverSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.getConstelacao().adicionarGolpe(rasteira);
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(95, tales.getVida(), 0);  
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(87, tales.getVida(), 0);
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(85, tales.getVida(), 0);
    }

    @Test
    public void saintDePrataComArmaduraMultiplicaFatorDanoDoGolpePorTres() throws Exception{
        Golpe chute = new Golpe("Chute", 5);
        Golpe soco = new Golpe("Soco", 8);
        Golpe rasteira = new Golpe("Rasteira", 2);
        Saint mirela = new SilverSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.getConstelacao().adicionarGolpe(rasteira);
        mirela.vestirArmadura();
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(85, tales.getVida(), 0); 
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(61, tales.getVida(), 0);  
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(55, tales.getVida(), 0);
          
    }

    @Test
    public void saintDeOuroSemArmaduraMantemFatorDanoDoGolpe() throws Exception{
        Golpe chute = new Golpe("Chute", 5);
        Golpe soco = new Golpe("Soco", 8);
        Golpe rasteira = new Golpe("Rasteira", 2);
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.getConstelacao().adicionarGolpe(rasteira);
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(95, tales.getVida(), 0); 
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(87, tales.getVida(), 0);  
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(85, tales.getVida(), 0);  
    }

    @Test
    public void saintDeOuroComArmaduraMultiplicaFatorDanoDoGolpePorQuatro() throws Exception{
        Golpe chute = new Golpe("Chute", 5);
        Golpe soco = new Golpe("Soco", 8);
        Golpe rasteira = new Golpe("Rasteira", 2);
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.getConstelacao().adicionarGolpe(rasteira);
        mirela.vestirArmadura();
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(80, tales.getVida(), 0); 
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(48, tales.getVida(), 0);  
        golpear.executar();
        assertEquals(100, mirela.getVida(), 0);
        assertEquals(40, tales.getVida(), 0);       
    }
    
    @Test(expected=ArithmeticException.class)
    public void naoGolpear() throws Exception {
         Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Saint tales = new BronzeSaint("Tales", "Escorpião");
        Golpear golpear = new Golpear(mirela, tales);
        golpear.executar();
    }
}
