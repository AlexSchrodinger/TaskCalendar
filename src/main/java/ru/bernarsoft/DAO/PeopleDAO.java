package ru.bernarsoft.DAO;


import ru.bernarsoft.model.People;

import java.sql.SQLException;
import java.util.List;

public interface PeopleDAO {

    public People create();

    public People read(int key);

    public void update(People people);

    public void delete(People people);

    public List<People> getAll() throws SQLException;

    public void upload();
}
