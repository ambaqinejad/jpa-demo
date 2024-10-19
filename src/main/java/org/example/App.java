package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Person p = entityManager.find(Person.class, 1);
            System.out.println(p);
            entityManager.getTransaction().begin();
            Person p2 = new Person();
            p2.setName("علی");
            entityManager.persist(p2);
            entityManager.getTransaction().commit();

            p = entityManager.find(Person.class, 2);
            System.out.println(p);
        }

        System.out.println("Hello World!");
    }
}
