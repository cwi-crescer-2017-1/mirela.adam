package br.com.crescer.exerciciosaula4;

import javax.persistence.Entity;

/**
 * @author Mirela
 */
public class LocacaoDao extends AbstractDao<Locacao, Long>{

    public LocacaoDao(Class<Entity> entity) {
        super(Locacao.class);
    }
    
}
