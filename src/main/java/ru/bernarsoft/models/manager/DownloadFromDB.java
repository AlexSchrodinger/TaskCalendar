package ru.bernarsoft.models.manager;

import ru.bernarsoft.models.DAO.CheckListDAO;
import ru.bernarsoft.models.DAO.PeopleDAO;
import ru.bernarsoft.models.DAO.TaskDAO;
import ru.bernarsoft.models.DAO.TypeTaskDAO;
import ru.bernarsoft.models.pojo.CheckLists;
import ru.bernarsoft.models.pojo.Peoples;
import ru.bernarsoft.models.pojo.Tasks;
import ru.bernarsoft.models.pojo.TypeTasks;
import ru.bernarsoft.parser.ParserXML;

import java.sql.SQLException;

public class DownloadFromDB {


    public DownloadFromDB() {
    }

    public void downloadPeoples() throws SQLException {
        Peoples peoples = new Peoples();
        PeopleDAO peopleDAO = new PeopleDAO();
        peoples.setPeoples(peopleDAO.getAll());
        ParserXML.parseToXml("people.xml", peoples, Peoples.class);
    }

    public void downloadChecks() throws SQLException {
        CheckLists checkLists = new CheckLists();
        CheckListDAO checkListDAO = new CheckListDAO();
        checkLists.setChecks(checkListDAO.getAll());
        ParserXML.parseToXml("check_list.xml", checkLists, CheckLists.class);
    }

    public void downloadTypes() throws SQLException {
        TypeTasks typeTasks = new TypeTasks();
        TypeTaskDAO typeTaskDAO = new TypeTaskDAO();
        typeTasks.setTypes(typeTaskDAO.getAll());
        ParserXML.parseToXml("type_task.xml", typeTasks, TypeTasks.class);
    }

    public void downloadTasks() throws SQLException {
        Tasks tasks = new Tasks();
        TaskDAO taskDAO = new TaskDAO();
        tasks.setTasks(taskDAO.getAll());
        ParserXML.parseToXml("task.xml", tasks, Tasks.class);
    }
}