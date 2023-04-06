package br.com.manager.action;

import br.com.manager.model.Company;
import br.com.manager.model.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowCompany {

    public String showExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Showing companies");

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        DataBase dataBase = new DataBase();
        Company company = dataBase.searchCompanyToId(id);

        System.out.println(company.getName());

        request.setAttribute("company", company);

        return "forward:formEditCompany.jsp";
    }
}