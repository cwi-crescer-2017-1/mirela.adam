
package br.com.crescer.exerciciosaula1;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author Mirela
 */
public class MeuParcelatorTest {
    
    public MeuParcelatorTest() {
    }
    
    /**
     * Test of calcular method, of class MeuParcelator.
     */
    @Test
    public void testCalcular() throws ParseException {
        MeuParcelator instance = new MeuParcelator();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Map<String, BigDecimal> result = instance.calcular(new BigDecimal(1000.00), 10, 10, s.parse("30/06/2016"));
        assertEquals(110.00, result.get("1. 30/06/2016 - ").doubleValue(), 0.01);
        assertEquals(110.00, result.get("2. 30/07/2016 - ").doubleValue(), 0.01);
        assertEquals(110.00, result.get("3. 29/08/2016 - ").doubleValue(), 0.01);
        assertEquals(110.00, result.get("4. 28/09/2016 - ").doubleValue(), 0.01);
        assertEquals(110.00, result.get("5. 28/10/2016 - ").doubleValue(), 0.01);
        assertEquals(110.00, result.get("6. 27/11/2016 - ").doubleValue(), 0.01);
        assertEquals(110.00, result.get("7. 27/12/2016 - ").doubleValue(), 0.01);
        assertEquals(110.00, result.get("8. 26/01/2017 - ").doubleValue(), 0.01);
        assertEquals(110.00, result.get("9. 25/02/2017 - ").doubleValue(), 0.01);
        assertEquals(110.00, result.get("10. 27/03/2017 - ").doubleValue(), 0.01);
    }
    
}
