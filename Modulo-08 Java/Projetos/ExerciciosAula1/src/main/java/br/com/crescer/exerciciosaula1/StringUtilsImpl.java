package br.com.crescer.exerciciosaula1;

import java.text.Normalizer;

/**
 * @author carloshenrique
 */
public class StringUtilsImpl implements StringUtils {

    public static String normalize(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    @Override
    public boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    @Override
    public String inverter(String string) {
        return isEmpty(string) ? string : new StringBuilder(string).reverse().toString();
    }

    @Override
    public int contaVogais(String string) {
        return isEmpty(string) ? 0 : string.length() - normalize(string).replaceAll("[aeiouAEIOU]", "").length();
    }

    @Override
    public boolean isPalindromo(String string) {
        return !isEmpty(string) &&  normalize(string).toLowerCase().replaceAll("\\s", "").equals(inverter(normalize(string).toLowerCase().replaceAll("\\s", "")));
    }

}
