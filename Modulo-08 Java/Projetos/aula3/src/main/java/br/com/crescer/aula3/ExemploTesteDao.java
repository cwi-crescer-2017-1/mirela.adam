package br.com.crescer.aula3;

/**
 *
 * @author mirela.adam
 */
public class ExemploTesteDao {

    public static void main(String[] args) {
 
        final TesteDao testDao = new TesteDao();
 
        testDao.drop();
 
        testDao.create();
 
        testDao.insert();
 
    }
 
}
 

