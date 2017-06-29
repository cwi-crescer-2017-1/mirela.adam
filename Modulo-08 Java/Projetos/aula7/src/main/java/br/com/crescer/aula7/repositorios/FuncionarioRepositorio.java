package br.com.crescer.aula7.repositorios;

import br.com.crescer.aula7.entidades.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mirela
 */
public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Long> {
    public Funcionario findById(Long id);
}
