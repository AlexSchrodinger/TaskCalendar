package ru.bernarsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.models.DAO.PeopleDAO;
import ru.bernarsoft.models.pojo.People;
import ru.bernarsoft.services.interfaces.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {

    private PeopleDAO peopleDAO;

    @Autowired
    public PeopleServiceImpl(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @Override
    public People authentication(String login, String password) throws PeopleDAOException {
        return peopleDAO.getUserByLoginAndPassword(login, password);
    }

    @Override
    public boolean registration(String firstName, String lastName, String email,
                                String login, String password) throws PeopleDAOException {
        return peopleDAO.registrationPeople(firstName, lastName, email,
                login, password);
    }
}