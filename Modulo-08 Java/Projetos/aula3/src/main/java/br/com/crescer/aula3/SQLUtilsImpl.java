package br.com.crescer.aula3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Mirela
 */
public class SQLUtilsImpl implements SQLUtils {

    //Deve possuir um metodo que execute as instruções contidas dentro de um arquivo, 
    //o mesmo tem que ser um ".sql".
    @Override
    public void runFile(String filename) {
        List<String> arquivo;
        String comando = "";
        File file = new File(filename);
        Path path = file.toPath();

        if (filename.contains(".sql")) {
            try {
                Statement statement = ConnectionUtils.getConnection().createStatement();
                arquivo = Files.readAllLines(path);
                for (String linha : arquivo) {
                    comando = linha.replace(";","");
                    statement.executeQuery(comando);
                }
            } catch (Exception e) {
                Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            throw new RuntimeException("Arquivo inválido");
        }
    }

    @Override
    public String executeQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File importCSV(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
