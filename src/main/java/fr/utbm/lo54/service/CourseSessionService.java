package fr.utbm.lo54.service;

import fr.utbm.lo54.beans.CourseSession;
import fr.utbm.lo54.repository.CourseSessionDAO;

import java.util.Date;
import java.util.List;

public class CourseSessionService {
    public List<CourseSession> listCourseSessions(){
        CourseSessionDAO courseSessionDAO = new CourseSessionDAO();
        return courseSessionDAO.listCourseSessions();
    }

    public List<CourseSession> listCourseSessions(String keyWord, Date date, String city){
        CourseSessionDAO courseSessionDAO = new CourseSessionDAO();
        return courseSessionDAO.listCourseSessions(keyWord, date, city);
    }

    public CourseSession lectureCourseSessions(long id){
        CourseSessionDAO courseSessionDAO = new CourseSessionDAO();
        return courseSessionDAO.lectureCourseSessions(id);
    }
}
