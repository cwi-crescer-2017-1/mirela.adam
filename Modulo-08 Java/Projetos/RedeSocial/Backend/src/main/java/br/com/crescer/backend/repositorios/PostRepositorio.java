package br.com.crescer.backend.repositorios;

import br.com.crescer.backend.entidades.Post;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mirela.adam
 */
public interface PostRepositorio extends CrudRepository<Post, Long> {

    public Post findById(Long id);

}