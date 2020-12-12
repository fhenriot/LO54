package fr.utbm.lo54.servlets;

import fr.utbm.lo54.beans.CourseSession;
import fr.utbm.lo54.beans.User;
import fr.utbm.lo54.service.CourseService;
import fr.utbm.lo54.service.CourseSessionService;
import fr.utbm.lo54.service.LocationService;
import fr.utbm.lo54.service.UserService;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet(name="Inscriptions", urlPatterns = "/Inscriptions")
public class Formulaire extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Formulaire.class.getName());
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

//        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
//
//        AppenderComponentBuilder console = builder.newAppender("stdout", "Console");
//        builder.add(console);
//
//        AppenderComponentBuilder file = builder.newAppender("log", "File");
//        file.addAttribute("fileName", "target/logging.log");
//        builder.add(file);
//
//        FilterComponentBuilder flow = builder.newFilter("MarkerFilter", Filter.Result.ACCEPT, Filter.Result.DENY);
//        flow.addAttribute("marker","FLOW");
//        LayoutComponentBuilder standard = builder.newLayout("PatternLayout");
//        standard.addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable");
//
//        console.add(standard);
//        file.add(standard);
//
//        RootLoggerComponentBuilder rootLogger = builder.newRootLogger("ERROR");
//        rootLogger.add(builder.newAppenderRef("stdout"));
//
//        builder.add(rootLogger);
//
//        LoggerComponentBuilder logger = builder.newLogger("fr","ERROR");
//        logger.add(builder.newAppenderRef("log"));
//        logger.addAttribute("additivity", false);
//
//        builder.add(logger);
//
//        Configurator.initialize(builder.build());
//
//        Logger l = LogManager.getLogger(builder);
//        l.error("grezmbvuiqgheuiorgoiuqsef bhguip");
//        l.debug("vbnbuifdbnwlkmhayzufdenahfsid,ugnhqeuifgqdzufbggqefoi^ghqeuivgp");
//
//        builder.writeXmlConfiguration(System.out);




        LOGGER.error("grezmbvuiqgheuiorgoiuqsef bhguip");
        LOGGER.debug("vbnbuifdbnwlkmhayzufdenahfsid,ugnhqeuifgqdzufbggqefoi^ghqeuivgp");

        //        new UserService().inscriptionClient(inscription);
        this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(req, resp);
    }
}

/*TODO
Interdire inscription quand session pleine
 */