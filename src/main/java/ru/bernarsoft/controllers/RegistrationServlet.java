package ru.bernarsoft.controllers;

import org.apache.log4j.Logger;
import ru.bernarsoft.services.PeopleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);
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
        if(PeopleService.registration(firstname, lastname, email, login, password)) {
            LOGGER.trace("true");
            resp.sendRedirect("/");
        } else {
            LOGGER.trace("false");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}