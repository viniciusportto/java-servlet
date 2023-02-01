package br.com.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listCompanies")
public class ListCompaniesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataBase dataBase = new DataBase();
        List<Company> companyList = dataBase.getCompanies();
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<ul>");
        for (Company company : companyList) {
            out.println("<li>" + company.getName() + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");


    }
}
