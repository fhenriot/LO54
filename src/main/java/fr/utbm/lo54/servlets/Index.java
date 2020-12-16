package fr.utbm.lo54.servlets;


import fr.utbm.lo54.service.CourseSessionService;
import fr.utbm.lo54.service.LocationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.hibernate.service.spi.ServiceException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name="index", urlPatterns = "/")
public class Index extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Formulaire.class.getName());
    private static final Marker APP = MarkerManager.getMarker("APP");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            List<?> location= new LocationService().listCities();
            req.setAttribute("location", location);
        }
        catch (ServiceException e){
            LOGGER.fatal(APP,e.getMessage());
        }
        List<?> courseSessions= new CourseSessionService().listCourseSessions();
        req.setAttribute("sessions", courseSessions);
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyWord = req.getParameter("keyWord");
        String sDate = req.getParameter("dateStart");
        String city = req.getParameter("city");
        List<?> courses = null;
        if (sDate.length() > 0){
            LOGGER.debug(APP, sDate.length());
            LOGGER.debug(APP,sDate);
            LOGGER.debug(APP,"2020-11-12");
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
                req.setAttribute("date", sDate);
                courses = new CourseSessionService().listCourseSessions(keyWord, date, city);
            } catch (ParseException e) {
                LOGGER.error(APP,e.getMessage());
            }
        }
        else{
            courses = new CourseSessionService().listCourseSessions(keyWord, city);
        }


        req.setAttribute("keyWord", keyWord);
        req.setAttribute("city", city);
        req.setAttribute("sessions", courses);
        List<?> location= new LocationService().listCities();
        req.setAttribute("location", location);
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

    }
}

/*TODO
* */