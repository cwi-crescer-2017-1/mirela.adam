package br.com.crescer.backend.repositorios;

import br.com.crescer.backend.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mirela.adam
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    public Usuario findById(Long id);

    public Usuario findOneByEmail(String email);
}