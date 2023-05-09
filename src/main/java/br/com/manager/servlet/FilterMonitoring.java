package br.com.manager.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/entrance")
public class FilterMonitoring implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        long before = System.currentTimeMillis();

        String action = request.getParameter("action");

        //execute the action
        chain.doFilter(request, response);

        long after = System.currentTimeMillis();
        System.out.println("Execution time of the action:" + action + " -> " + (after - before));

    }
}
