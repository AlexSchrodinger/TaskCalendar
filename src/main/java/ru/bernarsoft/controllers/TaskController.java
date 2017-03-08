package ru.bernarsoft.controllers;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.bernarsoft.models.pojo.Task;
import ru.bernarsoft.services.interfaces.TaskService;

import java.util.List;

@Controller
public class TaskController {
    private static final Logger LOGGER = Logger.getLogger(TaskController.class);

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/calendar/task", method = RequestMethod.GET)
    public ModelAndView showAllTask() {
        List<Task> listOfTask = taskService.getAllTasks();
        return new ModelAndView("task", "listOfTask", listOfTask);
    }
}