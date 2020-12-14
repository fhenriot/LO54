package fr.utbm.lo54.service;

import fr.utbm.lo54.beans.Course;
import fr.utbm.lo54.repository.CourseDAO;

import java.util.Date;
import java.util.List;

public class CourseService {
    public List<Course> listCourses(){
        CourseDAO cdao = new CourseDAO();
        return cdao.listCourse();
    }

    public List<?> listCourses(String keyWord) {
        CourseDAO cdao = new CourseDAO();
        return cdao.listCourse(keyWord);
    }
}
