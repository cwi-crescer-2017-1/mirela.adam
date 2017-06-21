package br.com.crescer.exerciciosaula1;

import java.util.Date;

/**
 *
 * @author Mirela
 */
public interface CalendarUtils {

    public enum DiaSemana {
        DOMINGO,
        SEGUNDA_FEIRA,
        TERCA_FEIRA,
        QUARTA_FEIRA,
        QUINTA_FEIRA,
        SEXTA_FEIRA,
        SABADO;
    }

    DiaSemana diaSemana(Date date);

    String tempoDecorrido(Date date);

}
