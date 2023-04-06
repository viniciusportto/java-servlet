package br.com.manager.action;

import br.com.manager.model.Company;
import br.com.manager.model.DataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCompanies {

    public void listExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Listing companies");

        DataBase dataBase = new DataBase();
        List<Company> companyList = dataBase.getCompanies();

        request.setAttribute("companies", companyList);

        RequestDispatcher reqdisp = request.getRequestDispatcher("/listCompanies.jsp");
        reqdisp.forward(request, response);
    }
}