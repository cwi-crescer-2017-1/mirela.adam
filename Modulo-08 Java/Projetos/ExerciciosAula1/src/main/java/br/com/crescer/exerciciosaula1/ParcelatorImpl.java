package br.com.crescer.exerciciosaula1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author carloshenrique
 */
public class ParcelatorImpl implements Parcelator {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyyy");
    private static final Calendar CALENDAR = Calendar.getInstance();

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {

        final BigDecimal qtdParcelas = BigDecimal.valueOf(numeroParcelas);

        final BigDecimal multiplicador = BigDecimal.valueOf(taxaJuros).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE);

        final BigDecimal vlTotal = valorParcelar.multiply(multiplicador);

        final BigDecimal vlParcela = vlTotal.divide(qtdParcelas, 2, RoundingMode.HALF_UP);

        // Calcula se existe resto na soma das parcelas.
        BigDecimal vlResto = vlParcela.multiply(qtdParcelas).subtract(vlTotal);

        final Map<String, BigDecimal> map = new LinkedHashMap<>();

        CALENDAR.setTime(dataPrimeiroVencimento);

        for (int i = 0; i < numeroParcelas; i++) {
            map.put(DATE_FORMAT.format(CALENDAR.getTime()), vlParcela.subtract(vlResto));
            vlResto = BigDecimal.ZERO;
            CALENDAR.add(Calendar.MONTH, 1);
        }
        return map;
    }

}
