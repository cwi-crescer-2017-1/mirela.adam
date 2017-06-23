package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @author mirela.adam
 */
public class Run {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        final Cliente cliente = em.find(Cliente.class, 1L);
        cliente.setNome("Mirela Haag Adam");
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        /*
        System.out.println(cliente.getNome());
        
        final Cliente c = new Cliente();
        c.setId(1L);
        c.setNome("Mirela");
               
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
         */
        em.close();
        emf.close();
    }
}
