package br.com.manager;

import br.com.manager.action.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/entrance")
public class SingleEntryServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAction = request.getParameter("action");

        String name = null;
        if(paramAction.equals("ListCompanies")){
            ListCompanies action = new ListCompanies();
            name = action.listExecute(request, response);

        }else if(paramAction.equals("RemoveCompany")) {
            RemoveCompany action = new RemoveCompany();
            name = action.removeExecute(request, response);

        } else if (paramAction.equals("ShowCompany")) {
            ShowCompany action = new ShowCompany();
            name = action.showExecute(request, response);

        } else if (paramAction.equals("EditCompany")) {
            EditCompany action = new EditCompany();
            name = action.editExecute(request, response);

        } else if (paramAction.equals("NewCompany")) {
            NewCompany action = new NewCompany();
            name = action.newCompanyExecute(request, response);
        } else if (paramAction.equals("NewCompanyForm")) {
            NewCompanyForm action = new NewCompanyForm();
            name = action.newCompanyExecute(request, response);
        }

        String[] typeAndAddress = name.split(":");
        if(typeAndAddress[0].equals("forward")) {
            RequestDispatcher reqdisp = request.getRequestDispatcher("WEB-INF/view/" + typeAndAddress[1]);
            reqdisp.forward(request, response);
        }else{
            response.sendRedirect(typeAndAddress[1]);
        }
    }
}