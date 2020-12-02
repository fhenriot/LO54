package fr.utbm.lo54.repository;

import fr.utbm.lo54.beans.CourseSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class CourseSessionDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lo54");
    EntityManager entityManager = null;

    public List<CourseSession> listCourseSessions(){
        List<CourseSession> sessions = new ArrayList<>();
        entityManager = entityManagerFactory.createEntityManager();
        sessions = (List<CourseSession>) entityManager.createQuery("from CourseSession").getResultList();
        return sessions;
    }

    public CourseSession lectureCourseSessions(long id) {
        CourseSession sessions = new CourseSession();
        entityManager = entityManagerFactory.createEntityManager();
        sessions = (CourseSession) entityManager.createQuery("from CourseSession where id=?1").setParameter(1,id).getSingleResult();
        return sessions;
    }
}
