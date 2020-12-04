package fr.utbm.lo54.servlets;

import fr.utbm.lo54.beans.CourseSession;
import fr.utbm.lo54.beans.User;
import fr.utbm.lo54.service.CourseService;
import fr.utbm.lo54.service.CourseSessionService;
import fr.utbm.lo54.service.LocationService;
import fr.utbm.lo54.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name="Inscriptions", urlPatterns = "/Inscriptions")
public class Formulaire extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id= Long.parseLong(req.getParameter("id")) ;
        CourseSession courseSessions = new CourseSessionService().lectureCourseSessions(id);
        req.setAttribute("session", courseSessions);
        float nombreClients= new UserService().comptageClientsParSession(courseSessions);
        System.out.println(nombreClients);
        int pourcentage= Math.round((nombreClients/courseSessions.getMaximum())*100);
        req.setAttribute("pourcentage", pourcentage);
        this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom= req.getParameter("user_name");
        String prenom= req.getParameter("user_firstname");
        String adresse= req.getParameter("user_address");
        String telephone= req.getParameter("user_phone");
        String email= req.getParameter("user_mail");
        long id= Long.parseLong(req.getParameter("id")) ;
        CourseSession courseSessions = new CourseSessionService().lectureCourseSessions(id);
        User inscription=new User(nom, prenom, adresse, telephone, email,courseSessions);
        new UserService().inscriptionClient(inscription);
        this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(req, resp);
    }
}

/*TODO
Interdire inscription quand session pleine
 */