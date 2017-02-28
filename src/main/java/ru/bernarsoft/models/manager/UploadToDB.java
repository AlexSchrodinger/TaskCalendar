package ru.bernarsoft.models.manager;

import ru.bernarsoft.models.DAO.PeopleDAO;
import ru.bernarsoft.models.pojo.Peoples;
import ru.bernarsoft.parser.ParserXML;

import java.io.File;

public class UploadToDB {


    public void uploadPeople() {

        Peoples peoples = (Peoples) ParserXML.parseFromXML(new File("people.xml"),
                        Peoples.class);

        PeopleDAO peopleDB = new PeopleDAO();
        peopleDB.upload(peoples.getPeoples());

    }
}