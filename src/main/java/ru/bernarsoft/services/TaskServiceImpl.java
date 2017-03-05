package ru.bernarsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bernarsoft.models.DAO.TaskDAO;
import ru.bernarsoft.models.pojo.Task;
import ru.bernarsoft.services.interfaces.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDAO.getAll();
    }

}