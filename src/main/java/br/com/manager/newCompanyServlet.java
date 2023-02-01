package br.com.manager;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/newcompany")
public class newCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Registering new company");

        String companyName = req.getParameter("Company name");
        Company company = new Company();
        company.setName(companyName);

        DataBase dataBase = new DataBase();
        dataBase.addCompany(company);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>Company " + companyName + " registered with successful</body></html>");

    }
}