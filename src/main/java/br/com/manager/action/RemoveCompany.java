package br.com.manager.action;

import br.com.manager.model.DataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCompany {

    public String removeExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("Removing companies");

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println(id);

        DataBase dataBase = new DataBase();
        dataBase.deleteCompany(id);

        return "redirect:entrance?action=ListCompanies";
    }
}
