package ru.bernarsoft.helper;


import java.sql.*;

public final class ConnectJDBC {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/calendar";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "root";

    private Connection connection;
    private Statement statement;
    public static ConnectJDBC instance;


    private ConnectJDBC() {
        try {
            Class.forName(DB_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectJDBC getInstance() {
        if (instance == null) {
            instance = new ConnectJDBC();
        }
        return instance;
    }

    public ResultSet query(String query) throws SQLException{
        statement = instance.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

}
