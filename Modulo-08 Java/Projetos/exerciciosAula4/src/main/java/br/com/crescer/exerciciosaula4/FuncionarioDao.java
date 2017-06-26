package br.com.crescer.exerciciosaula4;

import javax.persistence.Entity;

/**
 *
 * @author Mirela
 */
public class FuncionarioDao extends AbstractDao<Funcionario, Long>{

    public FuncionarioDao() {
        super(Funcionario.class);
    }
    
}
