package br.com.crescer.backend.controllers;

import br.com.crescer.backend.entidades.Post;
import br.com.crescer.backend.services.PostService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
   @GetMapping
    public Iterable<Post> getPostagens() {
        return service.listarTodos();
    }
    
    @PostMapping(consumes = "application/json")
    public Post publicar(@Valid @RequestBody Post p) {
        return service.cadastrar(p);
    }
    
}
