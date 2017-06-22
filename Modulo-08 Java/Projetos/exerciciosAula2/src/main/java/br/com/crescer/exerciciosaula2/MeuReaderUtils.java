package br.com.crescer.exerciciosaula2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author Mirela
 */
public class MeuReaderUtils implements ReaderUtils {

    @Override
    public String read(String string) throws Exception {
        
        if(string.contains(".txt")){
            
            File file = new File(string);
            if(!file.exists())
                throw new Exception("Arquivo inexistente.");
            
            final Reader reader = new FileReader(file);
            final BufferedReader bufferReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            bufferReader.lines().forEach( l ->  sb.append(l).append("\n") );
            return sb.toString();

        } else {
            throw new Exception("Arquivo deve ser .txt");
        }
    }
}
