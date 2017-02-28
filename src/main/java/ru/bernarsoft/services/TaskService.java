package ru.bernarsoft.services;

import ru.bernarsoft.models.DAO.TaskDAO;
import ru.bernarsoft.models.pojo.Task;

import java.util.List;

public class TaskService {

    public static List<Task> getAllTasks() {
        return TaskDAO.getAll();
    }

}