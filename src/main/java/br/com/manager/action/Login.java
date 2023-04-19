package br.com.manager.action;

import br.com.manager.model.DataBase;
import br.com.manager.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        System.out.println(login + " is online");

        DataBase dataBase = new DataBase();
        User user = dataBase.existUser(login, password);

        if (user != null){
            System.out.println("User exist");
            HttpSession session = request.getSession();
            session.setAttribute("userLogged", user);
            return "redirect:entrance?action=ListCompanies";
        }else {
            return "redirect:entrance?action=LoginForm";
        }
    }
}