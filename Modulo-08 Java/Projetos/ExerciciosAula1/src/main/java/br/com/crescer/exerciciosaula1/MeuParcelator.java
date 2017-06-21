package br.com.crescer.exerciciosaula1;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mirela
 */
public class MeuParcelator implements Parcelator{

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, 
                                            double taxaJuros, Date dataPrimeiroVencimento) {
        
        Map<String, BigDecimal> retorno = new HashMap<>();
        
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Calendar vencimento = Calendar.getInstance();
        vencimento.setTime(dataPrimeiroVencimento);
        
        BigDecimal valorComJuros = valorParcelar.add(valorParcelar.multiply(new BigDecimal(taxaJuros/100)));
        BigDecimal valorParcelas = valorComJuros.divide(new BigDecimal(numeroParcelas));
        
        for (int i = 1; i <= numeroParcelas; i++) {
            retorno.put(i + ". " + f.format(vencimento.getTime()) + " - ", valorParcelas);
            vencimento.add(Calendar.DAY_OF_MONTH, 30);
        }
        
        return retorno;
    }
}
