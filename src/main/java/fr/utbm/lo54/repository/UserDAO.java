package fr.utbm.lo54.repository;

import fr.utbm.lo54.beans.CourseSession;
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

    public long comptageClientsParSession(CourseSession id) {
        long compteur= 0;
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("select count(*) from User where course_session=?1");
        q.setParameter(1,id);
        compteur= (long) q.getSingleResult();
        return compteur;
    }

    public void creationUtilisateur(User utilisateur) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(utilisateur);
        entityManager.getTransaction().commit();
    }
}
