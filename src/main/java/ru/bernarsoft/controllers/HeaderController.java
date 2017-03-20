package ru.bernarsoft.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.bernarsoft.models.pojo.People;

import java.security.Principal;

@Controller
public class HeaderController {

//    @RequestMapping(value = "/header", method = RequestMethod.GET)
//    public ModelAndView shoqHeader(Principal principal) {
//
//
//        return new ModelAndView("header", "authpeople", authpeople);
//    }
}