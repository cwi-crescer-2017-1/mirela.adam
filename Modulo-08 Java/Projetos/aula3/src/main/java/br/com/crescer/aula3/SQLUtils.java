package br.com.crescer.aula3;

import java.io.File;

/*
 * @author Mirela
 */
public interface SQLUtils {

    void runFile(String filename);

    String executeQuery(String query);
    
    void importCSV(File file);
    
    File importCSV(String query);

}