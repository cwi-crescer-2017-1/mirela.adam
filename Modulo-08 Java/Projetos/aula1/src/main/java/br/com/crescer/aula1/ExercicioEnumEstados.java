/*
 Usando o enum descrito abaixo, utilize o StringBuffer para concatenar os nomes 
 dos estados separados por virgula, e exiba-os na console. 
 Se conseguir ordenado melhor.
 */
package br.com.crescer.aula1;

import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author mirela.adam
 */
public class ExercicioEnumEstados {
    public static void main(String[] args) {
           ArrayList<String> listaEstados = new ArrayList<>();
           StringBuffer sb = new StringBuffer();
           for(Estados e : Estados.values()){
               listaEstados.add(e.getNome());
           }
           Collections.sort(listaEstados);
           for(String estado : listaEstados){
               sb.append(estado + ",");
           }
           System.out.println(listaEstados.toString());      
    }
}
