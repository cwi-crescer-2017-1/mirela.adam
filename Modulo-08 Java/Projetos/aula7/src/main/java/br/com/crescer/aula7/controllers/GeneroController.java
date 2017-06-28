/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.entidades.Genero;
import br.com.crescer.aula7.services.GeneroService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirela.adam
 */
@RestController
@RequestMapping(value = "/Genero")
public class GeneroController {

    @Autowired
    GeneroService service;

    @GetMapping
    public Iterable<Genero> listarGeneros() {
        return service.listar();
    }

    @PostMapping
    public Genero cadastrarGenero(@RequestBody Genero g) {
        service.cadastrar(g);
        return g;
    }

    @DeleteMapping
    public Genero deletarGenero(@RequestBody Genero g){
        service.excluir(g);
        return g;
    }
    
    @PutMapping
    public Genero atualizarGenero(@RequestBody Genero g){
        service.cadastrar(g);
        return g;
    }
}
