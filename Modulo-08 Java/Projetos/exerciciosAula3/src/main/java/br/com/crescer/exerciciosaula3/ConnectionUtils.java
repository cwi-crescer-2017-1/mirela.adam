package br.com.crescer.exerciciosAula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mirela.adam
 */
public final class ConnectionUtils {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "teste";
    private static final String PASS = "teste";
 
    private ConnectionUtils() { }
 
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
 
}
