package be.belfius.zoo.repository;

import be.belfius.zoo.domain.Bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BearRepositoryJPA {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zooPu");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Bear bear){
        entityManager.getTransaction().begin();
        entityManager.persist(bear);
        entityManager.getTransaction().commit();
    }

}
