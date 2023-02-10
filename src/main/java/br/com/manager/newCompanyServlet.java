package br.com.manager;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/newcompany")
public class newCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Registering new company");

        String companyName = request.getParameter("Company name");
        String paramCompanyDate = request.getParameter("date");

        Date openDate = null;

        try {
            SimpleDateFormat simDatForm = new SimpleDateFormat("MM/dd/yyyy");
            openDate = simDatForm.parse(paramCompanyDate);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Company company = new Company();
        company.setName(companyName);
        company.setOpenDate(openDate);

        DataBase dataBase = new DataBase();
        dataBase.addCompany(company);

        request.setAttribute("company", company.getName());

        //redirecting by browser
        response.sendRedirect("listCompanies");

    }
}