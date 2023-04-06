package br.com.manager.action;

import br.com.manager.model.Company;
import br.com.manager.model.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewCompany {

    public void newCompanyExecute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

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
        response.sendRedirect("entrance?action=ListCompanies");

    }
}
