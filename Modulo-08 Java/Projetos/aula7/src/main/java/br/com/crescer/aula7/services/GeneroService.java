package br.com.crescer.aula7.services;
import br.com.crescer.aula7.entidades.Genero;
import br.com.crescer.aula7.repositorios.GeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirela.adam
 */
@Service
public class GeneroService {
    @Autowired
    GeneroRepositorio repositorio;

    public Iterable<Genero> listar() {
        return repositorio.findAll();
    }

    public Genero cadastrar(Genero g) {
        return repositorio.save(g);
    }

    public void excluir(Genero g) {
        repositorio.delete(g);
    }

    public Genero buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
    
}
