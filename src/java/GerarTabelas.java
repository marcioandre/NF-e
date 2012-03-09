
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcio
 */
public class GerarTabelas {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NFePU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
       // entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        
    }
}
