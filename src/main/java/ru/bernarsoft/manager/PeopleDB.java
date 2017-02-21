package ru.bernarsoft.manager;


import ru.bernarsoft.DAO.PeopleDAO;
import ru.bernarsoft.helper.ConnectJDBC;
import ru.bernarsoft.model.People;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PeopleDB implements PeopleDAO{

    private final ConnectJDBC connectJDBC;

    public PeopleDB(ConnectJDBC connectJDBC) {
        this.connectJDBC = connectJDBC;
    }

    @Override
    public People create() {
        return null;
    }

    @Override
    public People read(int key) {
        return null;
    }

    @Override
    public void update(People people) {

    }

    @Override
    public void delete(People people) {

    }

    @Override
    public List<People> getAll() throws SQLException {
        List<People> listOfPeople = new LinkedList<>();
        ResultSet resultSet = connectJDBC.query("select * from people");

        while (resultSet.next()){
            People people = new People(resultSet.getLong("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("email"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getBoolean("is_blocked"));

            listOfPeople.add(people);
        }
        return listOfPeople;
    }

    @Override
    public void upload() {

    }
}
