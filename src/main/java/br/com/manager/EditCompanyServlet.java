package br.com.manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/editCompany")
public class EditCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Changing Company.....");

        String companyName = request.getParameter("Company name");
        String paramCompanyDate = request.getParameter("date");
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Date openDate = null;

        try {
            SimpleDateFormat simDatForm = new SimpleDateFormat("MM/dd/yyyy");
            openDate = simDatForm.parse(paramCompanyDate);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        System.out.println(id);

        DataBase dataBase = new DataBase();
        Company company = dataBase.searchCompanyToId(id);
        company.setName(companyName);
        company.setOpenDate(openDate);

        response.sendRedirect("listCompanies");

    }
}
