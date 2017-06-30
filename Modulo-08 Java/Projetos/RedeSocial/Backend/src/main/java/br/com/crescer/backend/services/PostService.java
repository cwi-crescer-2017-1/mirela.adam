package br.com.crescer.backend.services;

import br.com.crescer.backend.entidades.Post;
import br.com.crescer.backend.repositorios.PostRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirela.adam
 */
@Service
public class PostService {
    @Autowired
    PostRepositorio repositorio;    
    
    public Iterable<Post> listar() {
        return repositorio.findAll();
    }

    public Post cadastrar(Post p) {
        return repositorio.save(p);
    }

    public void excluir(Post p) {
        repositorio.delete(p);
    }

    public Post buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
}
