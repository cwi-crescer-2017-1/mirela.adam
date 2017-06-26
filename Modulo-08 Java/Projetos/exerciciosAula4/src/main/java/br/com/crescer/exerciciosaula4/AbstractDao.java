package br.com.crescer.exerciciosaula4;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Mirela
 */
public abstract class AbstractDao<Entity, ID> implements CrudDao<Entity, ID> {
    
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final Session session = entityManager.unwrap(Session.class);
    private final Class<Entity> entity;
    
    public AbstractDao(Class<Entity> entity){
        this.entity = entity;
    }
    
    @Override
    public Entity save(Entity e) {
        entityManager.getTransaction().begin();
        session.saveOrUpdate(e);
        entityManager.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Object e) {
        entityManager.getTransaction().begin();
        session.delete(e);
        entityManager.getTransaction().commit();
    }

    @Override
    public Entity loadById(ID id) {
        return (Entity)session.load(entity, (Serializable) id);
    }

    @Override
    public List<Entity> findAll() {
        Criteria criteria = session.createCriteria(entity);
        return criteria.list();
    }
    
}
