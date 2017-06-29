package br.com.crescer.aula7.repositorios;

import br.com.crescer.aula7.entidades.Genero;
import org.springframework.data.repository.CrudRepository;

/*
 * @author mirela.adam
*/
public interface GeneroRepositorio extends CrudRepository<Genero, Long>{
    public Genero findById(Long id);  
}
