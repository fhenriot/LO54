package fr.utbm.lo54.servlets;

import fr.utbm.lo54.beans.CourseSession;
import fr.utbm.lo54.beans.User;
import fr.utbm.lo54.service.CourseSessionService;
import fr.utbm.lo54.service.UserService;
import org.apache.logging.log4j.*;


import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




@WebServlet(name="Inscriptions", urlPatterns = "/Inscriptions")
public class Formulaire extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Formulaire.class.getName());
    private static final Marker APP = MarkerManager.getMarker("APP");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id= Long.parseLong(req.getParameter("id")) ;
        try {
            CourseSession courseSessions = new CourseSessionService().lectureCourseSessions(id);
            req.setAttribute("session", courseSessions);
            float nombreClients= new UserService().comptageClientsParSession(courseSessions);
            int pourcentage= Math.round((nombreClients/courseSessions.getMaximum())*100);
            req.setAttribute("pourcentage", pourcentage);
            LOGGER.debug(APP,String.format("Nombre d'utilisateurs pour la session numéro %d:%d",courseSessions.getId(),(int)nombreClients));
        }
        catch (NoResultException e){
            LOGGER.error(APP,e.getMessage());
        }
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
        LOGGER.info(APP,String.format("Nouvel utilisateur enregistré %s",prenom));
        this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(req, resp);
    }
}

/*TODO
 */