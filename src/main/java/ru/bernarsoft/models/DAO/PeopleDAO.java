package ru.bernarsoft.models.DAO;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.bernarsoft.models.connector.Connector;
import ru.bernarsoft.models.pojo.People;

import java.sql.BatchUpdateException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PeopleDAO {

    private static final Logger LOGGER = LogManager.getLogger(PeopleDAO.class);
    private static final String SQL_CREATE_USER =
            "INSERT INTO people (firstname, lastname, email, login, password, role) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_GET_ALL = "SELECT * FROM people";
    private static final String SQL_UPLOAD_ALL = "INSERT INTO people (id, firstname, lastname, email, login, password, is_blocked) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_FIND_USER = "SELECT * FROM people WHERE login = ? AND password = ?";


    public People create() {
        return null;
    }

    public People read(int key) {
        return null;
    }


    public void update(People people) {

    }

    public void delete(People people) {

    }

    public List<People> getAll() throws SQLException {
        List<People> listOfPeople = new LinkedList<>();
        Connector connector = Connector.getInstance();
        ResultSet resultSet = connector.query(SQL_GET_ALL);

        while (resultSet.next()){
            People people = new People(resultSet.getLong("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("email"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getBoolean("is_blocked"),
                    resultSet.getString("role"));
            listOfPeople.add(people);
        }
        return listOfPeople;
    }


    public void upload(List<People> listOfPeople) {

        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_UPLOAD_ALL);
            for (People people : listOfPeople) {
                ps.setLong(1, people.getId());
                ps.setString(2, people.getFirstname());
                ps.setString(3, people.getLastname());
                ps.setString(4, people.getEmail());
                ps.setString(5, people.getLogin());
                ps.setString(6, people.getPassword());
                ps.setBoolean(7, people.getIs_blocked());
                ps.addBatch();
            }
            int[] count = ps.executeBatch();
            System.out.println("Add - " + count);

        } catch (BatchUpdateException e) {
            LOGGER.error("Batch error - " + e.getMessage());
        } catch (SQLException e) {
            LOGGER.error("SQL error - " + e.getMessage());
        }
    }


    public static boolean registrationPeople(String firstName, String lastName, String email,
                                      String login, String password) {
        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_CREATE_USER);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, login);
            ps.setString(5, password);
            ps.setString(6, "user");
            int count = ps.executeUpdate();
            if(count > 0){
                LOGGER.debug("inserted " + count);
                return true;
            }else{
                LOGGER.debug(login + " " + password + " not inserted");
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }
    public static People getUserByLoginAndPassword(String login, String password) {

        People people = null;
        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_FIND_USER);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                LOGGER.debug("find");
                people = new People(resultSet.getLong("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_blocked"),
                        resultSet.getString("role"));
            } else {
                LOGGER.debug(login + " " + password + " not found");
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return people;
    }
}
