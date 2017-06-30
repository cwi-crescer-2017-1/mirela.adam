package br.com.crescer.backend.services;

import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirela.adam
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositorio repositorio;    
    
    public Iterable<Usuario> listar() {
        return repositorio.findAll();
    }

    public Usuario cadastrar(Usuario u) {
        String senha = u.getSenha();
        String novaSenha = new BCryptPasswordEncoder().encode(senha);
        u.setSenha(novaSenha);
        return repositorio.save(u);
    }

    public void excluir(Usuario u) {
        repositorio.delete(u);
    }

    public Usuario buscarPorID(Long id) {
        return repositorio.findById(id);
    }  

    public Usuario buscarPorEmail(String email) {
        return repositorio.findOneByEmail(email);
    }
}
