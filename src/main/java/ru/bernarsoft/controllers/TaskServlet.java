package ru.bernarsoft.controllers;

import org.apache.log4j.Logger;
import ru.bernarsoft.models.pojo.Task;
import ru.bernarsoft.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/calendar/task")
public class TaskServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(TaskServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Task> listOfTask = TaskService.getAllTasks();
        req.setAttribute("listOfTask", listOfTask);
        req.getRequestDispatcher("/task.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}