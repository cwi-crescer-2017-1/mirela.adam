package br.com.crescer.backend.controllers;

import br.com.crescer.backend.entidades.Solicitacao;
import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.services.SolicitacaoService;
import br.com.crescer.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirela.adam
 */
@RestController
@RequestMapping(value = "/solicitacoes")
public class SolicitacaoController {
    @Autowired
    SolicitacaoService service;
    @Autowired
    UsuarioService userService;
    
    @GetMapping
    public Iterable<Solicitacao> getSolicitacoes(@AuthenticationPrincipal User user) {
        Usuario usuario = userService.buscarPorEmail(user.getUsername());
        return service.buscarPorID(usuario);
    }
}
