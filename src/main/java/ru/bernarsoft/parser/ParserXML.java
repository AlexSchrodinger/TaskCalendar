package ru.bernarsoft.parser;


import ru.bernarsoft.model.People;
import ru.bernarsoft.model.Peoples;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ParserXML {

    public static void parseToXml(String fileName, Object objectName, Class className) {
        File file = new File(fileName);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(className);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(objectName, file);
            marshaller.marshal(objectName, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
