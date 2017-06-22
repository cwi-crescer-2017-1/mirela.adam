package br.com.crescer.exerciciosaula2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mirela
 */
public class MeuFileUtils implements FileUtils {

    @Override
    public boolean mk(String string) {
        //O método mk deve criar um arquivo ou diretório.
        try {
            File file = new File(string);
            if(file.isDirectory()){
                return file.mkdir();
            } else {
                return file.createNewFile();
            }
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean rm(String string) {
        //O método rm deve excluir o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
        File file = new File(string);
        if (file.isDirectory()) {
                System.out.println("Arquivo é inválido");
                return false;
        }
        return file.exists()? file.delete() : false;
    }

    @Override
    public String ls(String string) {
        //O método ls deve mostra o caminho absoluto, se for um diretório listar o nome dos arquivos internos.
        File file = new File(string);
        if (file.isDirectory()) {
            return Arrays.toString(file.list());
        } 
        return file.getAbsolutePath();
    }

    @Override
    public boolean mv(String in, String out) {
        //O método mv deve mover o arquivo, 
        //caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
        File fileIn = new File(in);
        
        if (fileIn.isDirectory()) {
            System.out.println("Arquivo é inválido");
            return false;
        } 
        
        try {
            Files.move(fileIn.toPath(), Paths.get(out, fileIn.getName()), REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MeuFileUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
