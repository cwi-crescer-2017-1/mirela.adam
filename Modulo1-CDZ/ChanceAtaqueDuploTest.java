import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChanceAtaqueDuploTest {
    @Test
    public void estouComSorte33Porcento(){
        Sorteador sorteador = new DadoFalso(2);
        ChanceAtaqueDuplo chance = new ChanceAtaqueDuplo(sorteador);
        assertTrue(chance.lancaOsDados());
    }
    
    @Test
    public void estouSemSorte66Porcento(){
        Sorteador sorteador1 = new DadoFalso(1);
        ChanceAtaqueDuplo chance1 = new ChanceAtaqueDuplo(sorteador1);
        assertFalse(chance1.lancaOsDados());
        
        Sorteador sorteador2 = new DadoFalso(3);
        ChanceAtaqueDuplo chance2 = new ChanceAtaqueDuplo(sorteador2);
        assertFalse(chance2.lancaOsDados());
    }
}
