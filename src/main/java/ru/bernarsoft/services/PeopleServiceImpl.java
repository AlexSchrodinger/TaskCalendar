package ru.bernarsoft.services;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.models.DAO.PeopleDAO;
import ru.bernarsoft.models.entity.PeopleEntity;
import ru.bernarsoft.models.pojo.People;
import ru.bernarsoft.models.repository.PeopleRepository;
import ru.bernarsoft.services.interfaces.PeopleService;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    private PeopleDAO peopleDAO;


    @Autowired
    public PeopleServiceImpl(PeopleDAO peopleDAO, PeopleRepository peopleRepository) {
        this.peopleDAO = peopleDAO;

        this.peopleRepository = peopleRepository;
    }

    private final PeopleRepository peopleRepository;


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

    @Override
    public People getPeopleByLogin(String login) throws PeopleDAOException {
        return peopleDAO.getUserByLogin(login);
    }

    @Override
    public List<People> getAllPeoples() throws PeopleDAOException {
        List<People> listOfPeople = new ArrayList<>();
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();


        List<PeopleEntity> listOfEntity = peopleRepository.findAll();
        for (PeopleEntity entity: listOfEntity) {
//            people.setId((long)entity.getId());
//            people.setFirstname(entity.getFirstname());
//            people.setLastname(entity.getLastname());
//            people.setIs_blocked(entity.isBlocked());
            mapperFactory.classMap(PeopleEntity.class, People.class);
            MapperFacade mapper = mapperFactory.getMapperFacade();
            People people = mapper.map(entity, People.class);
            listOfPeople.add(people);
        }
        return listOfPeople;
    }

    @Override
    public People getPeopleById(int id) throws PeopleDAOException {
        People people = null;

        PeopleEntity entity = peopleRepository.findById(id);

        return peopleDAO.getUserById(id);
    }

    @Override
    public boolean updatePeople(People people) throws PeopleDAOException {
        return peopleDAO.updatePeople(people);
    }
}