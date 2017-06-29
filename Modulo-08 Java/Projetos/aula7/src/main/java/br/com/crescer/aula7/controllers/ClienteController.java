package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.entidades.Cliente;
import br.com.crescer.aula7.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/*
 * @author Mirela
 */
@RestController
@RequestMapping(value = "/Cliente")
public class ClienteController {
    @Autowired
    ClienteService service;

    @GetMapping
    public Iterable<Cliente> listarClientes() {
        return service.listar();
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente c) {
        service.cadastrar(c);
        return c;
    }

    @DeleteMapping
    public Cliente deletarCliente(@RequestBody Cliente c){
        service.excluir(c);
        return c;
    }
    
    @PutMapping
    public Cliente atualizarCliente(@RequestBody Cliente c){
        service.cadastrar(c);
        return c;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Cliente buscarClientePorID(@PathVariable("id") Long id) {
        return service.buscarPorID(id);
    }
}