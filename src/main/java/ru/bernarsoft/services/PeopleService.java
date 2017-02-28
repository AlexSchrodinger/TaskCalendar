package ru.bernarsoft.services;

import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.models.DAO.PeopleDAO;
import ru.bernarsoft.models.pojo.People;

public class PeopleService {

    public static People authentication(String login, String password) throws PeopleDAOException {
        return PeopleDAO.getUserByLoginAndPassword(login, password);
    }

    public static boolean registration(String firstName, String lastName, String email,
                                       String login, String password) throws PeopleDAOException {
        return PeopleDAO.registrationPeople(firstName, lastName, email,
                login, password);
    }
}