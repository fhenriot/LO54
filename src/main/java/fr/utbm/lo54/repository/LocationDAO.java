package fr.utbm.lo54.repository;

import fr.utbm.lo54.beans.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class LocationDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lo54");
    EntityManager entityManager = null;

    public ArrayList<Location> listCity() {
        ArrayList<Location> cities = new ArrayList<Location>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("from Location");
        cities = (ArrayList<Location>) q.getResultList();
        return cities;
    }
}
