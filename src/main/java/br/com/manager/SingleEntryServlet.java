package br.com.manager;

import br.com.manager.action.ListCompanies;

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
            action.execute(request, response);

        }else if(paramAction.equals("RemoveCompany")){
            System.out.println("Removing company");
        } else if (paramAction.equals("ShowCompany")) {
            System.out.println("Showing company data");

        }

    }
}
