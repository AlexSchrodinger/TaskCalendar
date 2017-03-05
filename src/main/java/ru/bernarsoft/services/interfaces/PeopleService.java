package ru.bernarsoft.services.interfaces;

import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.models.pojo.People;

public interface PeopleService {

    People authentication(String login, String password) throws PeopleDAOException;

    boolean registration(String firstName, String lastName, String email,
                                String login, String password) throws PeopleDAOException;
}
