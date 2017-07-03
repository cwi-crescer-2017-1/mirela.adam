package br.com.crescer.backend.services;

import br.com.crescer.backend.entidades.Amizade;
import br.com.crescer.backend.entidades.Post;
import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.repositorios.AmizadeRepositorio;
import br.com.crescer.backend.repositorios.PostRepositorio;
import java.util.List;
import java.util.stream.Collectors;
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
    
    @Autowired 
    AmizadeRepositorio amizadeRepo;

    public Iterable<Post> listar() {
        return repositorio.findAll();
    }

    public Post cadastrar(Post p) {
        return repositorio.save(p);
    }

    public void excluir(Post p) {
        repositorio.delete(p);
    }

    public Iterable<Post> buscarPorID(Usuario idusuario) {
        return repositorio.findAllByIdusuario(idusuario);
    }

    public Iterable<Post> listarTodos() {
        return repositorio.findAll();
    }

    public List<Post> buscarPostagensUsuarioEAmigos(Usuario u) {
        List<Long> ids = amizadeRepo.findByIdusuario(u)
               .stream()
               .map(Amizade::getIdamigo)
               .map(Usuario::getId)
               .collect(Collectors.toList());
       ids.add(u.getId());
       
       return repositorio.findByIdusuario_idIn(ids);
   } 
}
