package br.com.manager.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewCompanyForm {

    public String newCompanyExecute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

       return "forward:formNewCompany.jsp";
    }
}