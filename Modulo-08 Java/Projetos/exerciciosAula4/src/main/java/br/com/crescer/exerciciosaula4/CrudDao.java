package br.com.crescer.exerciciosaula4;

import java.util.List;

/**
 * @author Mirela
 * @param <Entity>
 * @param <ID>
 */
public interface CrudDao<Entity, ID> {
    
    Entity save(Entity e);

    void remove(Entity e);

    Entity loadById(ID id);

    List<Entity> findAll();
    
}