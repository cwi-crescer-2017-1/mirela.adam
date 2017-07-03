package br.com.crescer.backend.controllers;

import br.com.crescer.backend.entidades.Amizade;
import br.com.crescer.backend.entidades.Solicitacao;
import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.services.AmizadeService;
import br.com.crescer.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mirela
 */
@RestController
@RequestMapping(value = "/amigos")
public class AmizadeController {

    @Autowired
    AmizadeService service;

    @Autowired
    UsuarioService userService;

    @GetMapping
    public Iterable<Amizade> buscarAmigos(@AuthenticationPrincipal User user) {
        Usuario usuario = new Usuario();
        usuario = userService.buscarPorEmail(user.getUsername());
        return service.buscarPorIdUsuario(usuario);
    }
    
    @PostMapping(value = "/adicionar/{id}")
    public Solicitacao postAmizade(@PathVariable Long id, @AuthenticationPrincipal User user){
        Usuario usuario = userService.buscarPorEmail(user.getUsername());
        return service.criarSolicitacaoAmizade(usuario, id);
    }
    
    @PostMapping(value = "/aceitar/{id}")
    public Amizade aceitarAmizade(@PathVariable Long id, @AuthenticationPrincipal User user){
        Usuario usuario = userService.buscarPorEmail(user.getUsername());
        return service.aceitarSolicitacaoAmizade(usuario, id);
    }
    
    @PostMapping(value = "/recusar/{id}")
    public void recusarAmizade(@PathVariable Long id, @AuthenticationPrincipal User user){
        Usuario usuario = userService.buscarPorEmail(user.getUsername());
        service.recusarSolicitacaoAmizade(usuario, id);
    }
}
