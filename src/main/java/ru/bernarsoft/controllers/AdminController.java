package ru.bernarsoft.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.models.pojo.People;
import ru.bernarsoft.services.interfaces.PeopleService;

import java.sql.SQLException;
import java.util.List;

@Controller
public class AdminController {
    private static final Logger LOGGER = Logger.getLogger(AdminController.class);

    private final PeopleService peopleService;

    @Autowired
    public AdminController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getAllPeoples() {
        List<People> listOfPeoples;
        try {
            listOfPeoples = peopleService.getAllPeoples();

        } catch (PeopleDAOException e) {
            LOGGER.error(e);
            return new ModelAndView("error");
        }
        return new ModelAndView("admin", "listOfPeoples", listOfPeoples);
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
        return new ModelAndView("redirect:/admin");
    }
}