import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegraDeDanoTest {
    @Test 
    public void validarMetodoCalcularGoldSaintComArmaduraVestida() throws Exception {
        Saint mirela = new GoldSaint("Mirela","Escorpião");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.vestirArmadura();
        assertEquals(32,new RegraDeDano(mirela).calcular(),0);
    }
    
    @Test 
    public void validarMetodoCalcularGoldSaintSemArmaduraVestida() throws Exception {
        Saint mirela = new GoldSaint("Mirela","Escorpião");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        assertEquals(8,new RegraDeDano(mirela).calcular(),0);
    }
    
     @Test 
    public void validarMetodoCalcularSilverSaintComArmaduraVestida() throws Exception {
        Saint mirela = new SilverSaint("Mirela","Escorpião");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.vestirArmadura();
        assertEquals(24,new RegraDeDano(mirela).calcular(),0);
    }
    
    @Test 
    public void validarMetodoCalcularSilverSaintSemArmaduraVestida() throws Exception {
        Saint mirela = new SilverSaint("Mirela","Escorpião");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        assertEquals(8,new RegraDeDano(mirela).calcular(),0);
    }
    @Test 
    public void validarMetodoCalcularBronzeSaintComArmaduraVestida() throws Exception {
        Saint mirela = new BronzeSaint("Mirela","Escorpião");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.vestirArmadura();
        assertEquals(16,new RegraDeDano(mirela).calcular(),0);
    }
    
    @Test 
    public void validarMetodoCalcularBronzeSaintSemArmaduraVestida() throws Exception {
        Saint mirela = new BronzeSaint("Mirela","Escorpião");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        assertEquals(8,new RegraDeDano(mirela).calcular(),0);
    }
}