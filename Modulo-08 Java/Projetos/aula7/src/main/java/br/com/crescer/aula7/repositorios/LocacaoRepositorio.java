package br.com.crescer.aula7.repositorios;

import br.com.crescer.aula7.entidades.Locacao;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Mirela
 */
public interface LocacaoRepositorio extends CrudRepository<Locacao, Long> {
    public Locacao findById(Long id);
}
