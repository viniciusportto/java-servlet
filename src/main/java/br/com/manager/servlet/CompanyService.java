package br.com.manager.servlet;

import br.com.manager.model.Company;
import br.com.manager.model.DataBase;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/companies")
public class CompanyService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Company> companies = new DataBase().getCompanies();

        Gson gson = new Gson();
        String json = gson.toJson(companies);

        response.setContentType("application/json");
        response.getWriter().print(json);
    }
}
