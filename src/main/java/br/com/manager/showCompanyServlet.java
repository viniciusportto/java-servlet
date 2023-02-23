package br.com.manager;

import br.com.manager.model.Company;
import br.com.manager.model.DataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/showCompany")
public class showCompanyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        DataBase dataBase = new DataBase();
        Company company = dataBase.searchCompanyToId(id);

        System.out.println(company.getName());

        request.setAttribute("company", company);

        RequestDispatcher rd = request.getRequestDispatcher("/formEditCompany.jsp");
        rd.forward(request, response);

    }
}
