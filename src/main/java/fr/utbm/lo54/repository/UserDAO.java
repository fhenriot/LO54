package fr.utbm.lo54.repository;

import fr.utbm.lo54.beans.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class UserDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lo54");
    EntityManager entityManager = null;

    public ArrayList<User> listUser() {
        ArrayList<User> users = new ArrayList<User>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("from User");
        users = (ArrayList<User>) q.getResultList();
        return users;
    }
}
