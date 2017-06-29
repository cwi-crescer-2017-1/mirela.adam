package br.com.crescer.aula7.repositorios;

import br.com.crescer.aula7.entidades.Video;
import org.springframework.data.repository.CrudRepository;

/*
 * @author Mirela
 */
public interface VideoRepositorio extends CrudRepository<Video, Long> {
    public Video findById(Long id);
}
