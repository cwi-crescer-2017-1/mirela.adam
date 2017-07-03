package br.com.crescer.backend.security;

import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.services.UsuarioService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author mirela.adam
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {
    @Autowired 
    UsuarioService service;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = service.buscarPorEmail(username);
        return new User(u.getEmail(), u.getSenha(), new ArrayList<GrantedAuthority>());
    }

}