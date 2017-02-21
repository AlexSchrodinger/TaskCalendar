package ru.bernarsoft.manager;


import ru.bernarsoft.DAO.CheckListDAO;
import ru.bernarsoft.helper.ConnectJDBC;
import ru.bernarsoft.model.CheckList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CheckListDB implements CheckListDAO{

    private final ConnectJDBC connectJDBC;

    public CheckListDB(ConnectJDBC connectJDBC) {
        this.connectJDBC = connectJDBC;
    }
    @Override
    public CheckList create() {
        return null;
    }

    @Override
    public CheckList read(int key) {
        return null;
    }

    @Override
    public void update(CheckList check) {

    }

    @Override
    public void delete(CheckList check) {

    }

    @Override
    public List<CheckList> getAll() throws SQLException {
        List<CheckList> listOfCheck = new LinkedList<>();
        ResultSet resultSet = connectJDBC.query("select * from check_list");

        while (resultSet.next()){
            CheckList checkList = new CheckList(resultSet.getLong("id"),
                    resultSet.getLong("id_task"),
                    resultSet.getString("description"),
                    resultSet.getBoolean("is_complete"));

            listOfCheck.add(checkList);
        }
        return listOfCheck;
    }

    @Override
    public void upload() {

    }
}
