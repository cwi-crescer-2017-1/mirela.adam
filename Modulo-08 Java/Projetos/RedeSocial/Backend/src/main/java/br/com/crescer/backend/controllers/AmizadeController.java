package br.com.crescer.backend.controllers;

import br.com.crescer.backend.entidades.Amizade;
import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.services.AmizadeService;
import br.com.crescer.backend.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
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
}
