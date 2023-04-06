package br.com.manager;

import br.com.manager.action.*;

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

        if(paramAction.equals("ListCompanies")){
            ListCompanies action = new ListCompanies();
            action.listExecute(request, response);

        }else if(paramAction.equals("RemoveCompany")) {
            RemoveCompany action = new RemoveCompany();
            action.removeExecute(request, response);

        } else if (paramAction.equals("ShowCompany")) {
            ShowCompany action = new ShowCompany();
            action.showExecute(request, response);

        } else if (paramAction.equals("EditCompany")) {
            EditCompany action = new EditCompany();
            action.editExecute(request, response);

        } else if (paramAction.equals("NewCompany")) {
            NewCompany action = new NewCompany();
            action.newCompanyExecute(request, response);
        }
    }
}