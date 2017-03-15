package ru.bernarsoft.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.models.pojo.People;
import ru.bernarsoft.services.interfaces.PeopleService;


import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {
    private static final Logger LOGGER = Logger.getLogger(AdminController.class);

    private final PeopleService peopleService;

    @Autowired
    public AdminController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/admin/panel", method = RequestMethod.GET)
    public ModelAndView getAllPeoples(Principal principal) {
        List<People> listOfPeoples;
        People people;
        ModelAndView modelAndView = new ModelAndView("admin");

        try {
            listOfPeoples = peopleService.getAllPeoples();
            modelAndView.addObject("listOfPeoples", listOfPeoples);

            String userlogin = principal.getName();
            if(userlogin != null) {
                people = peopleService.getPeopleByLogin(userlogin);
                modelAndView.addObject("authpeople", people);
            }
        } catch (PeopleDAOException e) {
            LOGGER.error(e);
            return new ModelAndView("error");
        }


        return modelAndView;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
    public ModelAndView getPeopleById(@RequestParam int id) {
        People people;
        try {
           people = peopleService.getPeopleById(id);
        } catch (PeopleDAOException e) {
            LOGGER.error(e);
            return new ModelAndView("error");
        }
        return new ModelAndView("edit_people", "people", people);
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public ModelAndView editPeople(@ModelAttribute("people") People people) {
        try {
            peopleService.updatePeople(people);

        } catch (PeopleDAOException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("redirect:/admin/panel");
    }
}