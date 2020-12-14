package fr.utbm.lo54.repository;

import fr.utbm.lo54.beans.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lo54");
    EntityManager entityManager = null;

    public ArrayList<Course> listCourse() {
        ArrayList<Course> courses = new ArrayList<Course>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("from Course");
        courses = (ArrayList<Course>) q.getResultList();
        return courses;
    }

    public List<?> listCourse(String keyWord) {
        ArrayList<Course> courses = new ArrayList<Course>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("from Course where title like ?1");
        q.setParameter(1,keyWord);
        courses = (ArrayList<Course>) q.getResultList();
        return courses;
    }
}
