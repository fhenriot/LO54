package fr.utbm.lo54.service;

import fr.utbm.lo54.beans.User;
import fr.utbm.lo54.repository.UserDAO;

import java.util.List;

public class UserService {
    public List<User> listUsers(){
        UserDAO udao = new UserDAO();
        return udao.listUser();
    }
}
