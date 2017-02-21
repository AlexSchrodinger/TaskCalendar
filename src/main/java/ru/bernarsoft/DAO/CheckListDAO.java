package ru.bernarsoft.DAO;


import ru.bernarsoft.model.CheckList;

import java.sql.SQLException;
import java.util.List;

public interface CheckListDAO {

    public CheckList create();

    public CheckList read(int key);

    public void update(CheckList check);

    public void delete(CheckList check);

    public List<CheckList> getAll() throws SQLException;

    public void upload();
}
