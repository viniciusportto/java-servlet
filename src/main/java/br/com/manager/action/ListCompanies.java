package br.com.manager.action;

import br.com.manager.model.Company;
import br.com.manager.model.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCompanies implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Listing companies");

        DataBase dataBase = new DataBase();
        List<Company> companyList = dataBase.getCompanies();

        request.setAttribute("companies", companyList);

        return "forward:listCompanies.jsp";
    }
}