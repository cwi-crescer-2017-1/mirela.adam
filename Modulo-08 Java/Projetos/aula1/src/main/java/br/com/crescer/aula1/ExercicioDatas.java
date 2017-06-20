/*
Criar uma classe que leia a console esperando uma data no formato (dd/MM/yyyy)
e o numero de dias a ser somado e retorne a data no formato (dd/MM/yyyy).
 */
package br.com.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author mirela.adam
 */
public class ExercicioDatas {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
              
        System.out.println("Informe uma data no formato dd/mm/yyyy: ");
        String date = s.nextLine();
        System.out.println("Informe o numero de dias a ser adicionado: ");
        int diasParaAdicionar = s.nextInt();
        
       /* final Calendar calendar = new Calendar.getInstance();
        
        calendar.setTime(FORMAT.parse(date));
        calendar.add(Calendar.DAY_OF_YEAR, diasParaAdicionar);
        
        
        Date dataParaCalendar = new Date(date);
        
        System.out.println(dataParaCalendar);
        calendar.setTime(dataParaCalendar);
        calendar.add(calendar.DAY_OF_MONTH, diasParaAdicionar);
*/
        
       
    }
}
