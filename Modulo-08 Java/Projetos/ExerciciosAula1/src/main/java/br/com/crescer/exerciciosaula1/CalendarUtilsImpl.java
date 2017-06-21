package br.com.crescer.exerciciosaula1;

import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;

/**
 * @author carloshenrique
 */
public class CalendarUtilsImpl implements CalendarUtils {

    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final String TEMPLATE = "%s ano(s), %s messe(s) e %s dia(s)";

    @Override
    public DiaSemana diaSemana(Date date) {
        if (date == null) {
            return null;
        }
        CALENDAR.setTime(date);
        return CalendarUtils.DiaSemana.values()[CALENDAR.get(DAY_OF_WEEK) - 1];
    }

    @Override
    public String tempoDecorrido(Date date) {
        CALENDAR.setTime(new Date(this.getHoraZero(new Date()).getTime() - this.getHoraZero(date).getTime()));
        return String.format(TEMPLATE, (CALENDAR.get(YEAR) - 1970), CALENDAR.get(MONTH), CALENDAR.get(DAY_OF_MONTH));
    }

    /**
     * Retorna nova instancia da data com a hora zero do dia.
     *
     * @param date
     * @return date (00:00:00)
     */
    private Date getHoraZero(Date date) {
        CALENDAR.setTime(date);
        CALENDAR.set(CALENDAR.get(YEAR), CALENDAR.get(MONTH), CALENDAR.get(DAY_OF_MONTH), 0, 0, 0);
        return CALENDAR.getTime();
    }

}
