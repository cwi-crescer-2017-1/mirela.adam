import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest {
    @Test
    public void vestirArmadura() throws Exception{
        Saint milo = new BronzeSaint("Milo","Serpente");
        Movimento movimento = new VestirArmadura(milo);
        movimento.executar();
        assertTrue(milo.getArmaduraVestida());
    }

    @Test
    public void naoVestirArmadura() throws Exception{
        Saint milo = new BronzeSaint("Milo","Serpente");
        Movimento movimento = new VestirArmadura(milo);
        assertFalse(milo.getArmaduraVestida());
    }
    
    @Test(expected=NullPointerException.class)
    public void vestirArmaduraComSaintNull(){
        Saint shaina = null;
        Movimento movimento = new VestirArmadura(shaina);
        movimento.executar();
    }


}