package fr.utbm.lo54.service;

import fr.utbm.lo54.beans.CourseSession;
import fr.utbm.lo54.beans.User;
import fr.utbm.lo54.repository.UserDAO;

import java.util.List;

public class UserService {
    public List<User> listUsers(){
        UserDAO udao = new UserDAO();
        return udao.listUser();
    }
    public long comptageClientsParSession(CourseSession id){
        UserDAO udao = new UserDAO();
        return udao.comptageClientsParSession(id);
    }

    public void inscriptionClient(User utilisateur){
        UserDAO udao = new UserDAO();
        udao.creationUtilisateur(utilisateur);
    }
}
