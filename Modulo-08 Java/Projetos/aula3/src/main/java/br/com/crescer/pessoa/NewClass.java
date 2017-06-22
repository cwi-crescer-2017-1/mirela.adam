package br.com.crescer.pessoa;

/**
 * @author carloshenrique
 */
public class NewClass {

    public static void main(String[] args) {
        /*
        final PessoaDao pessoaDao = new PessoaDaoImpl();
        final Pessoa pessoa = new Pessoa();
        pessoa.setId(1l);
        pessoa.setNome("Carlos");
        pessoaDao.delete(pessoa);
        
        
        final PaisDao paisDao = new PaisDaoImpl();
        final Pais pais = new Pais();
        pais.setId(2l);
        pais.setNome("Argentina Update");
        pais.setSigla("AUP");
        paisDao.update(pais);
        */
        
        final PaisDao paisDao = new PaisDaoImpl();
        Pais p = paisDao.loadBy(2l);
        System.out.println(p.getNome());
        
        paisDao.delete(p);
    }
}
