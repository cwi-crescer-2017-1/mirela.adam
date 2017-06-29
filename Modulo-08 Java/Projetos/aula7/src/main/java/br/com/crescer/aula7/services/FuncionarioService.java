/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.services;

import br.com.crescer.aula7.entidades.Cliente;
import br.com.crescer.aula7.entidades.Funcionario;
import br.com.crescer.aula7.repositorios.ClienteRepositorio;
import br.com.crescer.aula7.repositorios.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mirela
 */
@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepositorio repositorio;    
    
    public Iterable<Funcionario> listar() {
        return repositorio.findAll();
    }

    public Funcionario cadastrar(Funcionario f) {
        return repositorio.save(f);
    }

    public void excluir(Funcionario f) {
        repositorio.delete(f);
    }

    public Funcionario buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
}
