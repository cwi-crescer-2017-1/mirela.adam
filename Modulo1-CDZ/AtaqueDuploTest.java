import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest {
    @Test
    public void verificaAtaqueDuploSaintDePrataComArmaduraVestida() throws Exception {
        Saint mirela = new SilverSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.vestirArmadura();
        Sorteador sorteador = new DadoFalso(2);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(52, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploSaintDePrataSemArmaduraVestida() throws Exception {
        Saint mirela = new SilverSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        Sorteador sorteador = new DadoFalso(2);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(84, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploSaintDeOuroComArmaduraVestida() throws Exception {
        Saint mirela = new GoldSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.vestirArmadura();
        Sorteador sorteador = new DadoFalso(2);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(36, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploSaintDeOuroSemArmaduraVestida() throws Exception {
        Saint mirela = new GoldSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        Sorteador sorteador = new DadoFalso(2);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(84, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploSaintDeBronzeComArmaduraVestida() throws Exception {
        Saint mirela = new BronzeSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.vestirArmadura();
        Sorteador sorteador = new DadoFalso(2);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(68, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploSaintDeBronzeSemArmaduraVestida() throws Exception {
        Saint mirela = new BronzeSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        Sorteador sorteador = new DadoFalso(2);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(84, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploGoldSaintComArmaduraQuandoErraSorteio() throws Exception {
        Saint mirela = new GoldSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.vestirArmadura();
        Sorteador sorteador = new DadoFalso(1);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(68, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploSilverSaintComArmaduraQuandoErraSorteio() throws Exception {
        Saint mirela = new SilverSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.vestirArmadura();
        Sorteador sorteador = new DadoFalso(1);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(76, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploBronzeSaintComArmaduraQuandoErraSorteio() throws Exception {
        Saint mirela = new BronzeSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.vestirArmadura();
        Sorteador sorteador = new DadoFalso(1);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(84, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploGoldSaintSemArmaduraQuandoErraSorteio() throws Exception {
        Saint mirela = new GoldSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        Sorteador sorteador = new DadoFalso(1);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(92, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploSilverSaintSemArmaduraQuandoErraSorteio() throws Exception {
        Saint mirela = new SilverSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        Sorteador sorteador = new DadoFalso(1);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(92, tales.getVida(), 0);     
    }
    
    @Test
    public void verificaAtaqueDuploBronzeSaintSemArmaduraQuandoErraSorteio() throws Exception {
        Saint mirela = new BronzeSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        Golpe soco = new Golpe("Soco", 8);
        mirela.getConstelacao().adicionarGolpe(soco);
        Sorteador sorteador = new DadoFalso(1);
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales, sorteador);
        ataqueDuplo.executar();
        assertEquals(92, tales.getVida(), 0);     
    }
    
    
}
