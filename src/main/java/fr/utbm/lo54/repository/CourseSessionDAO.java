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
        Query q = entityManager.createQuery(
                "from CourseSession " +
                        "where start_date>=?1 " +
                        "order by course.code");
        q.setParameter(1, new Date());
        sessions = q.getResultList();
        return sessions;
    }

    public CourseSession lectureCourseSessions(long id) {
        CourseSession sessions = new CourseSession();
        entityManager = entityManagerFactory.createEntityManager();
        sessions = (CourseSession) entityManager.createQuery("from CourseSession where id=?1").setParameter(1,id).getSingleResult();
        return sessions;
    }

    public List<CourseSession> listCourseSessions(String keyWord, Date date, String city) {
        if (city == null) {
            city="";
        }
        String whereCourse = "where ";
        if (keyWord.length()>0 && city.length()>0) {
            whereCourse+="course.title like CONCAT('%',?1,'%') and location.id=?2 and ";
        }
        else if (keyWord.length()>0){
            whereCourse+="course.title like CONCAT('%',?2,'%') and ";
        }
        else if (city.length()>0){
            whereCourse+="location.id=?2 and ";
        }
        whereCourse+="(start_date>=?3 and start_date<?4)";
        List<CourseSession> sessions = new ArrayList<>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery(
                "from CourseSession " +
                        whereCourse +
                        "order by course.code");
        if (keyWord.length()>0 && city.length()>0) {
            q.setParameter(1, keyWord);
            q.setParameter(2, Long.parseLong(city));
        }
        else if (keyWord.length()>0){
            q.setParameter(2, keyWord);
        }
        else if (city.length()>0){
            q.setParameter(2, Long.parseLong(city));
        }
        q.setParameter(3, date);
        q.setParameter(4, new Date(date.getTime() + (1000 * 60 * 60 * 24)));
        sessions = (List<CourseSession>) q.getResultList();
        return sessions;
    }

    public List<?> listCourseSessions(String keyWord, String city) {
        if (city == null) {
            city="";
        }
        String whereCourse = "where start_date>=?1 ";
        if (keyWord.length()>0 && city.length()>0) {
            whereCourse+="and (course.title like CONCAT('%',?2,'%') and location.id=?3)";
        }
        else if (keyWord.length()>0){
            whereCourse+="and course.title like CONCAT('%',?2,'%')";
        }
        else if (city.length()>0){
            whereCourse+="and location.id=?2";
        }
        List<CourseSession> sessions = new ArrayList<>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery(
                "from CourseSession " +
                        whereCourse +
                        "order by course.code");
        q.setParameter(1, new Date());
        if (keyWord.length()>0 && city.length()>0) {
            q.setParameter(2, keyWord);
            q.setParameter(3, Long.parseLong(city));
        }
        else if (keyWord.length()>0){
            q.setParameter(2, keyWord);
        }
        else if (city.length()>0){
            q.setParameter(2, Long.parseLong(city));
        }
        sessions = (List<CourseSession>) q.getResultList();
        return sessions;
    }
}
