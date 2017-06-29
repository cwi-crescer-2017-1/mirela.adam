package br.com.crescer.aula7.repositorios;

import br.com.crescer.aula7.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mirela
 */
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
    public Cliente findById(Long id);
}