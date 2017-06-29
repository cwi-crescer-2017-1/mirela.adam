package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.entidades.Funcionario;
import br.com.crescer.aula7.services.FuncionarioService;
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
@RequestMapping(value = "/Funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioService service;

    @GetMapping
    public Iterable<Funcionario> listarFuncionarios() {
        return service.listar();
    }

    @PostMapping
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario f) {
        service.cadastrar(f);
        return f;
    }

    @DeleteMapping
    public Funcionario deletarFuncionario(@RequestBody Funcionario f){
        service.excluir(f);
        return f;
    }
    
    @PutMapping
    public Funcionario atualizarFuncionario(@RequestBody Funcionario f){
        service.cadastrar(f);
        return f;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Funcionario buscarFuncionarioPorID(@PathVariable("id") Long id) {
        return service.buscarPorID(id);
    }
}
