package br.com.crescer.aula2;

import br.com.crescer.exerciciosaula1.StringUtilsImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author carloshenrique
 */
public class Exemplo2 {

    public static void main(String[] args) throws IOException {
        try (final Reader reader = new FileReader("aula2.txt");
                final BufferedReader bufferReader = new BufferedReader(reader);) {
            while (true) {
                final String readLine = bufferReader.readLine();
                
                if (!new StringUtilsImpl().isEmpty(readLine)) {
                    System.out.println(readLine);
                }
                // Tempo de espera para ler o buffer.
                Thread.sleep(500l);
            }
        } catch (IOException | InterruptedException e) {
            //
        }

    }
}
