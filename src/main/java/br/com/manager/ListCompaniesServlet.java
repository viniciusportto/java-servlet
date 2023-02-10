package br.com.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listCompanies")
public class ListCompaniesServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataBase dataBase = new DataBase();
        List<Company> companyList = dataBase.getCompanies();

        request.setAttribute("companies", companyList);

        RequestDispatcher reqdisp = request.getRequestDispatcher("/listCompanies.jsp");
        reqdisp.forward(request, response);

    }
}