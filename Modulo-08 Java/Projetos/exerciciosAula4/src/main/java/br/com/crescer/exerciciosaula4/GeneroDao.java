package br.com.crescer.exerciciosaula4;

import javax.persistence.Entity;

/**
 *
 * @author Mirela
 */
public class GeneroDao extends AbstractDao<Genero, Long>{

    public GeneroDao() {
        super(Genero.class);
    }
    
}
