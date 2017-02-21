package ru.bernarsoft.manager;


import ru.bernarsoft.DAO.TaskDAO;
import ru.bernarsoft.helper.ConnectJDBC;
import ru.bernarsoft.model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TaskDB implements TaskDAO{

    private final ConnectJDBC connectJDBC;

    public TaskDB(ConnectJDBC connectJDBC) {
        this.connectJDBC = connectJDBC;
    }
    @Override
    public Task create() {
        return null;
    }

    @Override
    public Task read(int key) {
        return null;
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Task task) {

    }

    @Override
    public List<Task> getAll() throws SQLException {
        List<Task> listOfTask = new LinkedList<>();
        ResultSet resultSet = connectJDBC.query("select * from task");

        while (resultSet.next()) {
            Task task = new Task(resultSet.getLong("id"),
                    resultSet.getString("event"),
                    resultSet.getDate("date"),
                    resultSet.getDate("time"),
                    resultSet.getLong("id_user"),
                    resultSet.getLong("id_type"),
                    resultSet.getBoolean("is_complete"));
            listOfTask.add(task);
        }

        return listOfTask;
    }

    @Override
    public void upload() {

    }
}
