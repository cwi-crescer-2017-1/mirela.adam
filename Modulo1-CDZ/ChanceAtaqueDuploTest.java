import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChanceAtaqueDuploTest {
    @Test
    public void estouComSorte33Porcento(){
        Sorteador sorteador = new DadoFalso(2);
        SorteDoDia sorte = new SorteDoDia(sorteador);
        assertTrue(sorte.estouComSorte());
    }
    
    @Test
    public void estouSemSorte66Porcento(){
        Sorteador sorteador = new DadoFalso(1);
        SorteDoDia sorte = new SorteDoDia(sorteador);
        assertFalse(sorte.estouComSorte());
        sorteador = new DadoFalso(3);
        assertFalse(sorte.estouComSorte());
    }
}
