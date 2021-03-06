package ru.bernarsoft.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.services.PeopleServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);

    private PeopleServiceImpl peopleServiceImpl;


    @Autowired
    public void setPeopleServiceImpl(PeopleServiceImpl peopleServiceImpl) {
        this.peopleServiceImpl = peopleServiceImpl;
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext
                (this, config.getServletContext());
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.trace("doPost");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if(peopleServiceImpl.registration(firstname, lastname, email, login, password)) {
                LOGGER.trace("true");
                resp.sendRedirect("/");
            } else {
                LOGGER.trace("false");
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        } catch (PeopleDAOException e) {
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}