package ru.bernarsoft.services.interfaces;

import ru.bernarsoft.models.pojo.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    boolean setCompleteTask(int id);
    List<Task> getTasksByType(int id_type);
}
