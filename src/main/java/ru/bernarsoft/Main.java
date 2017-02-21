package ru.bernarsoft;


import ru.bernarsoft.helper.ConnectJDBC;
import ru.bernarsoft.manager.CheckListDB;
import ru.bernarsoft.manager.PeopleDB;
import ru.bernarsoft.manager.TaskDB;
import ru.bernarsoft.manager.TypeTaskDB;
import ru.bernarsoft.model.*;
import ru.bernarsoft.parser.ParserXML;

import java.sql.SQLException;

public class Main {



    public static void main(String[] args) throws SQLException {
        ConnectJDBC connectJDBC = ConnectJDBC.getInstance();

        Peoples peoples = new Peoples();
        PeopleDB peopleDB = new PeopleDB(connectJDBC);
        peoples.setPeoples(peopleDB.getAll());
        ParserXML.parseToXml("people.xml", peoples, Peoples.class);

        CheckLists checkLists = new CheckLists();
        CheckListDB checkListDB = new CheckListDB(connectJDBC);
        checkLists.setChecks(checkListDB.getAll());
        ParserXML.parseToXml("check_list.xml", checkLists, CheckLists.class);


        TypeTasks typeTasks = new TypeTasks();
        TypeTaskDB typeTaskDB = new TypeTaskDB(connectJDBC);
        typeTasks.setTypes(typeTaskDB.getAll());
        ParserXML.parseToXml("type_task.xml", typeTasks, TypeTasks.class);

        Tasks tasks = new Tasks();
        TaskDB taskDB = new TaskDB(connectJDBC);
        tasks.setTasks(taskDB.getAll());
        ParserXML.parseToXml("task.xml", tasks, Tasks.class);

    }
}
