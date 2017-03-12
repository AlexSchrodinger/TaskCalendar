package ru.bernarsoft.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.common.utilities.Notificator;
import ru.bernarsoft.models.pojo.People;
import ru.bernarsoft.services.interfaces.PeopleService;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@WebInitParam(name = "notification", value = "off")
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ServletConfig servletConfig;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private Notificator notificator;

    @Autowired
    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkPeople(@RequestParam String login,
                              @RequestParam String password) {
        People people;
        try {
            people = peopleService.authentication(login, password);
        } catch (PeopleDAOException e) {
            return "error";
        }

        if(people.getId() != 0) {
            request.getSession().setAttribute("firstName", people.getFirstname());
            LOGGER.debug("Auth");
            if(("admin").equals(people.getRole())) {
                if(("on").equals(servletConfig.getInitParameter("notification"))) {
                    notificator.notifyAdminEnter(people.getEmail());
                }
//                return "admin";
                return "redirect:/admin";
            }


            return "redirect:/calendar/task";
        } else {
            LOGGER.debug("Fail auth");
            return "error";
        }
    }
}