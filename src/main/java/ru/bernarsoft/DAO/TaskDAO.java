package ru.bernarsoft.DAO;


import ru.bernarsoft.model.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDAO {

    public Task create();

    public Task read(int key);

    public void update(Task task);

    public void delete(Task task);

    public List<Task> getAll() throws SQLException;

    public void upload();
}
