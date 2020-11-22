package fr.utbm.lo54.servlets;

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
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("lo54");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        List<?> location= entityManager.createQuery("SELECT city from location").getResultList();
        req.setAttribute("location", location);
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
