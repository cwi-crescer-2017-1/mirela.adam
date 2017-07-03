package br.com.crescer.backend.controllers;

import br.com.crescer.backend.entidades.Amizade;
import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.services.UsuarioService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirela.adam
 */
@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosController {
    @Autowired
    UsuarioService service;

    @GetMapping
    public Map<String, Object> listarUsuarios(Authentication authentication) {
        User u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", u);
        return hashMap;
    }
   
    @PostMapping 
    public Usuario cadastrarUsuario(@RequestBody Usuario u) {
        service.cadastrar(u);
        return u;
    }

    @DeleteMapping
    public Usuario deletarUsuario(@RequestBody Usuario u){
        service.excluir(u);
        return u;
    }
    
    @PutMapping
    public Usuario atualizarUsuario(@RequestBody Usuario u){
        service.cadastrar(u);
        return u;
    }
    
    @RequestMapping(value="/perfil/{id}", method=RequestMethod.GET)
    public Usuario buscarUsuarioPorID(@PathVariable("id") Long id) {
        return service.buscarPorID(id);
    }
    
    @RequestMapping(value="/{email}", method=RequestMethod.GET)
    public Usuario buscarUsuarioPorEmail(@PathVariable("email") String email) {
        return service.buscarPorEmail(email);
    }
    
    @RequestMapping(value="/buscar/{texto}", method=RequestMethod.GET)
    public Iterable<Usuario> buscarUsuariosPorTexto(@PathVariable("texto") String texto) {
        return service.buscarPorEmailOuNome(texto);
    }
    
   @GetMapping(value = "/amigos")
    public Collection<Amizade> getAmigosUsuario(@AuthenticationPrincipal User user) {
        return service.buscarPorEmail(user.getUsername()).getAmizadeCollection1();
    }
}