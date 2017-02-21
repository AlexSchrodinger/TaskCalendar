package ru.bernarsoft.DAO;


import ru.bernarsoft.model.TypeTask;

import java.sql.SQLException;
import java.util.List;

public interface TypeTaskDAO {

    public TypeTask create();

    public TypeTask  read(int key);

    public void update(TypeTask  typeTask);

    public void delete(TypeTask  typeTask);

    public List<TypeTask > getAll() throws SQLException;

    public void upload();
}
