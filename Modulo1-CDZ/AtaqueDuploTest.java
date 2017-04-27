import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest {
    @Test
    public void verificaAtaqueDuplo() throws Exception {
        Saint mirela = new SilverSaint("Mirela","Escorpião");
        Saint tales = new BronzeSaint("Tales","Aquário");
        
        Movimento ataqueDuplo = new AtaqueDuplo(mirela, tales);
        
        
    }
}
