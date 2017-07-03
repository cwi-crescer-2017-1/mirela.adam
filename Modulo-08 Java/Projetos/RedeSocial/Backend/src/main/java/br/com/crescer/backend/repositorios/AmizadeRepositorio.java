package br.com.crescer.backend.repositorios;

import br.com.crescer.backend.entidades.Amizade;
import br.com.crescer.backend.entidades.Usuario;
import java.util.Collection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mirela
 */
public interface AmizadeRepositorio extends CrudRepository<Amizade, Long> {
    public Iterable<Amizade> findByIdusuario(Usuario idusuario);
}
