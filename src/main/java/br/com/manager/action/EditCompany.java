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

public class EditCompany {

    public void editExecute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String companyName = request.getParameter("Company name");
        String paramCompanyDate = request.getParameter("date");
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println("Changing Company " + id);

        Date openDate = null;

        try {
            SimpleDateFormat simDatForm = new SimpleDateFormat("MM/dd/yyyy");
            openDate = simDatForm.parse(paramCompanyDate);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        DataBase dataBase = new DataBase();
        Company company = dataBase.searchCompanyToId(id);
        company.setName(companyName);
        company.setOpenDate(openDate);

        response.sendRedirect("entrance?action=ListCompanies");

    }
}