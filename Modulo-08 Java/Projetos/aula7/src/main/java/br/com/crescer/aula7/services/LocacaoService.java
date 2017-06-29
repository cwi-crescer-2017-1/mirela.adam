package br.com.crescer.aula7.services;

import br.com.crescer.aula7.entidades.Locacao;
import br.com.crescer.aula7.entidades.Video;
import br.com.crescer.aula7.repositorios.LocacaoRepositorio;
import br.com.crescer.aula7.repositorios.VideoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mirela
 */
@Service
public class LocacaoService {
    @Autowired
    LocacaoRepositorio repositorio;    
    
    public Iterable<Locacao> listar() {
        return repositorio.findAll();
    }

    public Locacao cadastrar(Locacao l) {
        return repositorio.save(l);
    }

    public void excluir(Locacao l) {
        repositorio.delete(l);
    }

    public Locacao buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
}
