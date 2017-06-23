package br.com.crescer.aula3;

/**
 *
 * @author Mirela
 */
public class teste {
    public static void main(String[] args) {
        SQLUtilsImpl sql = new SQLUtilsImpl();
        sql.runFile("tabelas.sql");
    }
}
