package br.com.crescer.backend.repositorios;

import br.com.crescer.backend.entidades.Post;
import br.com.crescer.backend.entidades.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mirela.adam
 */
public interface PostRepositorio extends CrudRepository<Post, Long> {

    public Iterable<Post> findAllByIdusuario(Usuario idusuario);

    public List<Post> findByIdusuario_idIn(List<Long> ids);
}
