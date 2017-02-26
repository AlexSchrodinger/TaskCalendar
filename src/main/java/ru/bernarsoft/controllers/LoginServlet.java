package ru.bernarsoft.controllers;

import org.apache.log4j.Logger;
import ru.bernarsoft.models.pojo.People;
import ru.bernarsoft.services.PeopleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        People people = PeopleService.authentication(login, password);
        if(people.getId() != 0) {
            req.getSession().setAttribute("access", "AccessIsAllowed");
            LOGGER.debug(req.getSession().getId());
            LOGGER.debug("auth");
            resp.sendRedirect("/calendar/task");
        } else {
            LOGGER.debug("fail auth");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}