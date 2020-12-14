package fr.utbm.lo54.repository;

import fr.utbm.lo54.beans.CourseSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class CourseSessionDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lo54");
    EntityManager entityManager = null;

    public List<CourseSession> listCourseSessions(){
        List<CourseSession> sessions = new ArrayList<>();
        entityManager = entityManagerFactory.createEntityManager();
        sessions = (List<CourseSession>) entityManager.createQuery(
                "from CourseSession order by course.code")
                .getResultList();
        return sessions;
    }

    public CourseSession lectureCourseSessions(long id) {
        CourseSession sessions = new CourseSession();
        entityManager = entityManagerFactory.createEntityManager();
        sessions = (CourseSession) entityManager.createQuery("from CourseSession where id=?1").setParameter(1,id).getSingleResult();
        return sessions;
    }

    public List<CourseSession> listCourseSessions(String keyWord, Date date, String city) {
        List<CourseSession> sessions = new ArrayList<>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery(
                "from CourseSession " +
                        "where course.title=?1 or start_date=?2 or location.id=?3" +
                        "order by course.code");
        q.setParameter(1, keyWord);
        q.setParameter(2, date.toString());
        q.setParameter(3, city);
        sessions = (List<CourseSession>) q.getResultList();
        return sessions;
    }

    public List<?> listCourseSessions(String keyWord, String city) {
        List<CourseSession> sessions = new ArrayList<>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery(
                "from CourseSession " +
                        "where course.title=?1 or location.id=?2" +
                        "order by course.code");
        q.setParameter(1, keyWord);
        q.setParameter(2, city);
        sessions = (List<CourseSession>) q.getResultList();
        return sessions;
    }
}
