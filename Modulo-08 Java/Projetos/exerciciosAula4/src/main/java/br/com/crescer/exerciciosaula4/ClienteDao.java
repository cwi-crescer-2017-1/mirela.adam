package br.com.crescer.exerciciosaula4;
import javax.persistence.Entity;
/**
 *
 * @author Mirela
 */
public class ClienteDao extends AbstractDao<Cliente, Long>{

    public ClienteDao() {
        super(Cliente.class);
    }
    
}
