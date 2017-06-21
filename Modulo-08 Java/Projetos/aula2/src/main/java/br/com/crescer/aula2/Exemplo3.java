package br.com.crescer.aula2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author carloshenrique
 */
public class Exemplo3 {

    public static void main(String[] args) {

        try (
                final FileWriter fileWriter = new FileWriter("aula2.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            bufferedWriter.append("Exemplo4");
            
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException e) {
            //...
        }

    }
}
