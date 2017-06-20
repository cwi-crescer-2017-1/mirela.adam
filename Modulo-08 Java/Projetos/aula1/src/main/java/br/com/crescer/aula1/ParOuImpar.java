package br.com.crescer.aula1;

import java.util.Scanner;

/**
 *
 * @author mirela.adam
 */
public class ParOuImpar {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            
			int numero = Integer.parseInt(scanner.nextLine());
			if(numero % 2 == 0) {
				System.out.printf("O numero %d eh par", numero);
			} else {
				System.out.printf("O numero %d eh impar", numero);
			}
        } catch (Exception e) {
            //...
        }
    }
}
