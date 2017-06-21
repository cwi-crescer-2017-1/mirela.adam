package br.com.crescer.exerciciosaula1;

import br.com.crescer.exerciciosaula1.CalendarUtils.DiaSemana;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirela
 */
public class MeuCalendarioUtilsTest {
    
    public MeuCalendarioUtilsTest() {
    }
    
    /**
     * Test of diaSemana method, of class MeuCalendarioUtils.
     * @throws java.text.ParseException
     */
    @Test
    public void testDiaSemanaPosterior() throws ParseException {
        MeuCalendarioUtils teste = new MeuCalendarioUtils();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(DiaSemana.QUINTA_FEIRA, teste.diaSemana(df.parse("26/10/2017")));
    }
    
    @Test
    public void testDiaSemanaAnterior() throws ParseException {
        MeuCalendarioUtils teste = new MeuCalendarioUtils();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(DiaSemana.DOMINGO, teste.diaSemana(df.parse("26/10/2014")));
    }

    /**
     * Test of tempoDecorrido method, of class MeuCalendarioUtils.
     */  

}
