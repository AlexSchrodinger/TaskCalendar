package ru.bernarsoft.services.interfaces;

import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.models.entity.PeopleEntity;
import ru.bernarsoft.models.pojo.People;

import java.util.List;

public interface PeopleService {

    People authentication(String login, String password) throws PeopleDAOException;

    boolean registration(String firstName, String lastName, String email,
                                String login, String password) throws PeopleDAOException;

    People getPeopleByLogin(String login) throws PeopleDAOException;

    List<People> getAllPeoples() throws PeopleDAOException;

    People getPeopleById(int id) throws PeopleDAOException;

    boolean updatePeople(People people)  throws PeopleDAOException;
}
