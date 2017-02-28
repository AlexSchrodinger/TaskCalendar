package ru.bernarsoft.controllers.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/calendar/*")
public class FilterServlet implements Filter {
    private static final Logger LOGGER = Logger.getLogger(FilterServlet.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if(("AccessIsAllowed").equals(httpRequest.getSession().getAttribute("access"))) {
            LOGGER.debug("Access Is Allowed");
            chain.doFilter(request, response);
        } else
            LOGGER.debug("Access Denied");
            httpRequest.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}