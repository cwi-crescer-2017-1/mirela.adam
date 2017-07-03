package br.com.crescer.backend.services;

import br.com.crescer.backend.entidades.Solicitacao;
import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.repositorios.SolicitacaoRepositorio;
import br.com.crescer.backend.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirela.adam
 */
@Service
public class SolicitacaoService {
    @Autowired
    SolicitacaoRepositorio repositorio;

    @Autowired
    UsuarioRepositorio userRepositorio;
    
    public Iterable<Solicitacao> buscarPorID(Usuario u) {       
        return repositorio.findByIdreceptor(u);
        
    }    
}
