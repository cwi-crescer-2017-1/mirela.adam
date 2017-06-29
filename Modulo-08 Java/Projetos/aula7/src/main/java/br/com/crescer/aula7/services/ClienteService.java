package br.com.crescer.aula7.services;

import br.com.crescer.aula7.entidades.Cliente;
import br.com.crescer.aula7.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Mirela
 */
@Service
public class ClienteService {
    @Autowired
    ClienteRepositorio repositorio;    
    
    public Iterable<Cliente> listar() {
        return repositorio.findAll();
    }

    public Cliente cadastrar(Cliente c) {
        return repositorio.save(c);
    }

    public void excluir(Cliente c) {
        repositorio.delete(c);
    }

    public Cliente buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
}
