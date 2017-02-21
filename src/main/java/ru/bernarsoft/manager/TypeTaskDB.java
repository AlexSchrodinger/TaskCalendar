package ru.bernarsoft.manager;


import ru.bernarsoft.DAO.TypeTaskDAO;
import ru.bernarsoft.helper.ConnectJDBC;
import ru.bernarsoft.model.TypeTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TypeTaskDB implements TypeTaskDAO {

    private final ConnectJDBC connectJDBC;

    public TypeTaskDB(ConnectJDBC connectJDBC) {
        this.connectJDBC = connectJDBC;
    }

    @Override
    public TypeTask create() {
        return null;
    }

    @Override
    public TypeTask read(int key) {
        return null;
    }

    @Override
    public void update(TypeTask typeTask) {

    }

    @Override
    public void delete(TypeTask typeTask) {

    }

    @Override
    public List<TypeTask> getAll() throws SQLException {
        List<TypeTask> listOfType = new LinkedList<>();
        ResultSet resultSet = connectJDBC.query("select * from type_task");

        while (resultSet.next()){
            TypeTask typeTask = new TypeTask(resultSet.getLong("id"),
                    resultSet.getString("type"),
                    resultSet.getDate("date_from"),
                    resultSet.getDate("date_to"));
            listOfType.add(typeTask);
        }
        return listOfType;
    }

    @Override
    public void upload() {

    }
}
