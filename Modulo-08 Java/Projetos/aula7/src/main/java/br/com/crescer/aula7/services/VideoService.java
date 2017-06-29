package br.com.crescer.aula7.services;
import br.com.crescer.aula7.entidades.Video;
import br.com.crescer.aula7.repositorios.VideoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mirela
 */
@Service
public class VideoService {
    @Autowired
    VideoRepositorio repositorio;    
    
    public Iterable<Video> listar() {
        return repositorio.findAll();
    }

    public Video cadastrar(Video v) {
        return repositorio.save(v);
    }

    public void excluir(Video v) {
        repositorio.delete(v);
    }

    public Video buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
}
