package br.com.manager.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hi")
public class HelloServlet extends HttpServlet {

    public  HelloServlet(){
        System.out.println("Creating Hello world servlet.");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Hello Servlet :)");
        out.println("</body>");
        out.println("</html");

        System.out.println("The Servlet HelloServlet was called");

    }
}