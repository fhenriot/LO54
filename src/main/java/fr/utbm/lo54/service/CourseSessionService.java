package fr.utbm.lo54.service;

import fr.utbm.lo54.beans.CourseSession;
import fr.utbm.lo54.repository.CourseSessionDAO;

import java.util.List;

public class CourseSessionService {
    public List<CourseSession> listCourseSessions(){
        CourseSessionDAO courseSessionDAO = new CourseSessionDAO();
        return courseSessionDAO.listCourseSessions();
    }
}
