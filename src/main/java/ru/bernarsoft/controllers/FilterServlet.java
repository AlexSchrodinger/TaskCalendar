package ru.bernarsoft.controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/calendar/*")
public class FilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if(("AccessIsAllowed").equals(httpRequest.getSession().getAttribute("access"))) {
            chain.doFilter(request, response);
        } else
            httpRequest.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}