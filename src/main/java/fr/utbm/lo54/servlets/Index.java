package fr.utbm.lo54.servlets;

import fr.utbm.lo54.beans.Location;
import fr.utbm.lo54.repository.LocationDAO;
import fr.utbm.lo54.service.CourseSessionService;
import fr.utbm.lo54.service.CourseService;
import fr.utbm.lo54.service.LocationService;
import fr.utbm.lo54.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="index", urlPatterns = "/")
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<?> location= new LocationService().listCities();
        List<?> courseSessions = new CourseSessionService().listCourseSessions();
        req.setAttribute("location", location);
//        List<?> course= new CourseService().listCourses();
//        req.setAttribute("course", course);
        req.setAttribute("sessions", courseSessions);
        List<?> user= new UserService().listUsers();
        req.setAttribute("user", user);
        req.setAttribute("course_session", courseSessions);
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}

/*TODO
* Vérifier date passée
* Faire filtres
*
*
* */