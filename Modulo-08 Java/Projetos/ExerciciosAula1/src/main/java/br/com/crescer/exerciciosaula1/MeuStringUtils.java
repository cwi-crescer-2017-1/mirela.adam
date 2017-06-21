package br.com.crescer.exerciciosaula1;
/**
 *
 * @author Mirela
 */
public class MeuStringUtils implements StringUtils {

    @Override
    public boolean isEmpty(String string) {
        return (string == null || string.isEmpty());
    }

    @Override
    public String inverter(String string) {
        StringBuffer sb = new StringBuffer(string);
        return sb.reverse().toString();
    }

    @Override
    public int contaVogais(String string) {
        int contador = 0;
        for(int i = 0; i < string.length(); i++){
            String s = Character.toString(string.charAt(i)).toLowerCase();
            if(s.matches("[aãáàâäeéèêëiíìîïoõóòôöuúùûü]")){
                contador++;
            }            
        }
        return contador;
    }

    @Override
    public boolean isPalindromo(String string) {
        string = string.replaceAll("[ ]","");
        string = string.replaceAll("[áàãâä]","a");
        string = string.replaceAll("[éèêë]","e");
        string = string.replaceAll("[íìîï]", "i");
        string = string.replaceAll("[õóòôö]", "o");
        string = string.replaceAll("[úùûü]", "u");
        
        StringBuffer sb = new StringBuffer(string);
        String stringAoContrario = sb.reverse().toString();
        
        return string.compareToIgnoreCase(stringAoContrario) == 0;
    }
    
}
