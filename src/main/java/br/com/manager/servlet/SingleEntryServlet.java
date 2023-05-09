package br.com.manager.servlet;

import br.com.manager.action.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/entrance")
public class SingleEntryServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAction = request.getParameter("action");

//        HttpSession session = request.getSession();
//        boolean userAreNotLogged = (session.getAttribute("userLogged") == null);
//        boolean itsProtectedAction = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
//
//        if(itsProtectedAction && userAreNotLogged){
//            response.sendRedirect("entrance?action=LoginForm");
//            return;
//        }

        String className = "br.com.manager.action." + paramAction;

        String name;
        try {
           Class classe = Class.forName(className);
           Action action = (Action) classe.newInstance();//load the class with the name
            name = action.execute(request,response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] typeAndAddress = name.split(":");
        if(typeAndAddress[0].equals("forward")) {
            RequestDispatcher reqdisp = request.getRequestDispatcher("WEB-INF/view/" + typeAndAddress[1]);
            reqdisp.forward(request, response);
        }else{
            response.sendRedirect(typeAndAddress[1]);
        }

//  Codigo sem a assinatura do método na interface Action, seria um tipo de assinatura informal, sempre repetindo o execute em cada if
//                    String name = null;
//                    if(paramAction.equals("ListCompanies")){
//                        ListCompanies action = new ListCompanies();
//                        name = action.listExecute(request, response);
//
//                    }else if(paramAction.equals("RemoveCompany")) {
//                        RemoveCompany action = new RemoveCompany();
//                        name = action.removeExecute(request, response);
//
//                    } else if (paramAction.equals("ShowCompany")) {
//                        ShowCompany action = new ShowCompany();
//                        name = action.showExecute(request, response);
//
//                    } else if (paramAction.equals("EditCompany")) {
//                        EditCompany action = new EditCompany();
//                        name = action.editExecute(request, response);
//
//                    } else if (paramAction.equals("NewCompany")) {
//                        NewCompany action = new NewCompany();
//                        name = action.newCompanyExecute(request, response);
//                    } else if (paramAction.equals("NewCompanyForm")) {
//                        NewCompanyForm action = new NewCompanyForm();
//                        name = action.newCompanyExecute(request, response);
//                    }
    }
}