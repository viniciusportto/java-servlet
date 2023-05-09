package br.com.manager.servlet;

import br.com.manager.action.Action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(urlPatterns = "/entrance")
public class ControllerFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("ControllerFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAction = request.getParameter("action");
        String className = "br.com.manager.action." + paramAction;

        String name;
        try {
            Class classe = Class.forName(className);
            Action action = (Action) classe.newInstance();//load the class with the name
            name = action.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] typeAndAddress = name.split(":");
        if (typeAndAddress[0].equals("forward")) {
            RequestDispatcher reqdisp = request.getRequestDispatcher("WEB-INF/view/" + typeAndAddress[1]);
            reqdisp.forward(request, response);
        } else {
            response.sendRedirect(typeAndAddress[1]);
        }
    }
}