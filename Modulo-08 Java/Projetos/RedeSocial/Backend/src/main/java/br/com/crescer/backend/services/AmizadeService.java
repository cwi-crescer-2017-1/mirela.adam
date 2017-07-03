package br.com.crescer.backend.services;

import br.com.crescer.backend.entidades.Amizade;
import br.com.crescer.backend.entidades.Usuario;
import br.com.crescer.backend.repositorios.AmizadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mirela
 */
@Service
public class AmizadeService {
     @Autowired
     AmizadeRepositorio repositorio;
     
    public Iterable<Amizade> buscarPorIdUsuario(Usuario idusuario) {
        return repositorio.findByIdusuario(idusuario);
  }
}
