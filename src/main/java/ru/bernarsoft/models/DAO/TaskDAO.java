package ru.bernarsoft.models.DAO;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.bernarsoft.models.connector.Connector;
import ru.bernarsoft.models.pojo.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Component
public class TaskDAO {
    private static final Logger LOGGER = LogManager.getLogger(TaskDAO.class);

    private static final String SQL_GET_ALL = "SELECT * FROM task";

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

    public List<Task> getAll() {
        Connector connector = Connector.getInstance();
        List<Task> listOfTask = new LinkedList<>();

        try {
            ResultSet resultSet = connector.query(SQL_GET_ALL);
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

}
