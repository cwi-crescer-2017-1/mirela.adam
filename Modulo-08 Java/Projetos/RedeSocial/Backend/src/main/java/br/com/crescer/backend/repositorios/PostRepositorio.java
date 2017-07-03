package br.com.crescer.backend.repositorios;

import br.com.crescer.backend.entidades.Post;
import br.com.crescer.backend.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mirela.adam
 */
public interface PostRepositorio extends CrudRepository<Post, Long> {

    public Iterable<Post> findAllByIdusuario(Usuario idusuario);
}
