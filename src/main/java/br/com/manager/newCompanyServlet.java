package br.com.manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/newcompany")
public class newCompanyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("Registering new company");

        String companyName = req.getParameter("Company name");
        String paramCompanyDate = req.getParameter("date");

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

        PrintWriter out = resp.getWriter();
        out.println("<html><body>Company " + companyName + " registered with successful</body></html>");

        //call JSP
        RequestDispatcher reqdis = req.getRequestDispatcher("/newCompanyCreate.jsp");
        req.setAttribute("company", company.getName());
        reqdis.forward(req, resp);

    }
}