package br.com.manager.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(urlPatterns = "/entrance")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("AuthorizationFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAction = request.getParameter("action");

        HttpSession session = request.getSession();
        boolean userAreNotLogged = (session.getAttribute("userLogged") == null);
        boolean itsProtectedAction = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));

        if(itsProtectedAction && userAreNotLogged){
            response.sendRedirect("entrance?action=LoginForm");
            return;
        }

        chain.doFilter(servletRequest, servletResponse);

    }
}
