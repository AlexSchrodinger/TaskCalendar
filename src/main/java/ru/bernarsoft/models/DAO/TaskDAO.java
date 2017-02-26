package ru.bernarsoft.models.DAO;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.bernarsoft.models.connector.Connector;
import ru.bernarsoft.models.pojo.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TaskDAO {
    private static final Logger LOGGER = LogManager.getLogger(TaskDAO.class);

    public TaskDAO() {
    }

    public Task create() {
        return null;
    }


    public Task read(int key) {
        return null;
    }


    public void update(Task task) {

    }

    public void delete(Task task) {

    }

    public static List<Task> getAll() {
        Connector connector = Connector.getInstance();
        List<Task> listOfTask = new LinkedList<>();

        try {
            ResultSet resultSet = connector.query("select * from task");
            while (resultSet.next()) {

                Task task = new Task(resultSet.getLong("id"),
                        resultSet.getString("event"),
                        resultSet.getDate("date"),
                        resultSet.getLong("id_people"),
                        resultSet.getLong("id_type"),
                        resultSet.getBoolean("is_complete"));
                listOfTask.add(task);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return listOfTask;
    }


    public void upload() {

    }
}
