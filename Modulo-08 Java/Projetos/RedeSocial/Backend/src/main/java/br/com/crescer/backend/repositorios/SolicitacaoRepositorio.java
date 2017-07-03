package br.com.crescer.backend.repositorios;

import br.com.crescer.backend.entidades.Post;
import br.com.crescer.backend.entidades.Solicitacao;
import br.com.crescer.backend.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mirela.adam
 */
public interface SolicitacaoRepositorio extends CrudRepository<Solicitacao, Long> {

    public Iterable<Solicitacao> findByIdreceptor(Usuario usuario);

    public Solicitacao findOneByIdreceptorAndIdsolicitante(Usuario usuarioLogado, Usuario solicitante);

}