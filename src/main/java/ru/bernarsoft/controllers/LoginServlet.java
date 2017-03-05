package ru.bernarsoft.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.common.utilities.Notificator;
import ru.bernarsoft.models.pojo.People;
import ru.bernarsoft.services.PeopleServiceImpl;
import ru.bernarsoft.services.interfaces.PeopleService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/login",
            initParams = @WebInitParam(name = "notification", value = "on"))

public class LoginServlet extends HttpServlet{
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

    private PeopleService peopleService;

    @Autowired
    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext
                (this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        People people = null;
        try {
            people = peopleService.authentication(login, password);
        } catch (PeopleDAOException e) {
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }

        if(people.getId() != 0) {
            req.getSession().setAttribute("firstName", people.getFirstname());
            LOGGER.debug(req.getSession().getId());
            LOGGER.debug("auth");
            resp.sendRedirect("/calendar/task");
            if(("on").equals(getServletConfig().getInitParameter("notification"))) {
                if(("admin").equals(people.getRole())) {
                    Notificator.notifyAdminEnter(people.getEmail());
                }
            }

        } else {
            LOGGER.debug("fail auth");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}