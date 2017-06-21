
package br.com.crescer.exerciciosaula1;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Mirela
 */
public class MeuCalendarioUtils implements CalendarUtils {

    @Override
    public DiaSemana diaSemana(Date date) {
        if (date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return DiaSemana.values()[calendar.get(Calendar.DAY_OF_WEEK) - 1];       
    }

    @Override
    public String tempoDecorrido(Date date) {
        Calendar calendarDataAtual = Calendar.getInstance();
        Calendar calendarParametro = Calendar.getInstance();
        calendarParametro.setTime(date);
        
        int anos = calendarDataAtual.get(Calendar.YEAR) - calendarParametro.get(Calendar.YEAR); 
        int meses =  Math.abs(calendarDataAtual.get(Calendar.MONTH) - calendarParametro.get(Calendar.MONTH));
        int dias = Math.abs(calendarDataAtual.get(Calendar.DATE) - calendarParametro.get(Calendar.DATE));
        
        String retorno = anos + " ano(s), " + meses + " mese(s) e " + dias + " dia(s)";
        return retorno;
    }
    
}
