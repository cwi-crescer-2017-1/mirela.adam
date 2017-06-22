package br.com.crescer.exerciciosaula2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author Mirela
 */
public class MeuWriterUtils implements WriterUtils{

    @Override
    public void write(String file, String conteudo) throws Exception {
        if(file.contains(".txt")){
            
            File arquivo = new File(file);
            if(!arquivo.exists())
                throw new Exception("Arquivo inexistente.");
            
            final Writer writer = new FileWriter(file, true);
            final BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.append(conteudo);
            bufferWriter.newLine();
            bufferWriter.flush();

        } else {
            throw new Exception("Arquivo deve ser .txt");
        }
    }
    
}
