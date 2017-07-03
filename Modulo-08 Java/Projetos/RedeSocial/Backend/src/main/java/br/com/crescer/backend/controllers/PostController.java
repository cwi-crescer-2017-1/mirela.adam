package br.com.crescer.backend.controllers;

import br.com.crescer.backend.entidades.Post;
import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.services.PostService;
import br.com.crescer.backend.services.UsuarioService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirela.adam
 */
@RestController
@RequestMapping(value = "/postagens")
public class PostController {

    @Autowired
    PostService service;
    
    @Autowired
    UsuarioService userService;

    @GetMapping
    public Iterable<Post> getPostagens() {
        return service.listarTodos();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Iterable<Post> getPostagensPorUsuario(@PathVariable("id") Long id) {
        Usuario u = userService.buscarPorID(id);
        return service.buscarPorID(u);
    }
    
    @RequestMapping(value = "/home/{id}", method = RequestMethod.GET)
    public List<Post> getPostagensUsuarioEAmigos(@PathVariable("id") Long id) {
        Usuario u = userService.buscarPorID(id);
        return service.buscarPostagensUsuarioEAmigos(u);
    }

    @PostMapping(consumes = "application/json")
    public Post publicar(@Valid @RequestBody Post p) {
        return service.cadastrar(p);
    }

}
