package br.com.crescer.backend.services;

import br.com.crescer.backend.entidades.Amizade;
import br.com.crescer.backend.entidades.Solicitacao;
import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.repositorios.AmizadeRepositorio;
import br.com.crescer.backend.repositorios.SolicitacaoRepositorio;
import br.com.crescer.backend.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mirela
 */
@Service
public class AmizadeService {

    @Autowired
    AmizadeRepositorio repositorio;
    
    @Autowired 
    UsuarioRepositorio userRepo;
    
    @Autowired
    SolicitacaoRepositorio solicitacaoRepo;

    public Iterable<Amizade> buscarPorIdUsuario(Usuario idusuario) {
        return repositorio.findByIdusuario(idusuario);
    }
    
    public Solicitacao criarSolicitacaoAmizade(Usuario usuarioLogado, Long id) {
        Usuario solicitado = userRepo.findOneById(id);
        Solicitacao solicitacao = new Solicitacao();
        
        solicitacao.setId(0L);
        solicitacao.setIdsolicitante(usuarioLogado);
        solicitacao.setIdreceptor(solicitado);
        
        return solicitacaoRepo.save(solicitacao);
    }

    public Amizade aceitarSolicitacaoAmizade(Usuario usuarioLogado, Long id) {
        Usuario solicitante = userRepo.findOneById(id);
        
        Amizade amizadeA = new Amizade();
        amizadeA.setId(0L);
        amizadeA.setIdusuario(usuarioLogado);
        amizadeA.setIdamigo(solicitante);
        repositorio.save(amizadeA);
        
        Amizade amizadeB = new Amizade();
        amizadeB.setId(0L);
        amizadeB.setIdusuario(solicitante);
        amizadeB.setIdamigo(usuarioLogado);
        repositorio.save(amizadeB);
        
        Solicitacao s = solicitacaoRepo.findOneByIdreceptorAndIdsolicitante(usuarioLogado, solicitante);
        solicitacaoRepo.delete(s);
        return amizadeA;
    }

    public void recusarSolicitacaoAmizade(Usuario usuarioLogado, Long id) {
        Usuario solicitante = userRepo.findOneById(id);
        Solicitacao s = solicitacaoRepo.findOneByIdreceptorAndIdsolicitante(usuarioLogado, solicitante);
        solicitacaoRepo.delete(s);
    }
}
