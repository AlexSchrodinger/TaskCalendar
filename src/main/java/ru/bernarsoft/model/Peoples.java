package ru.bernarsoft.model;


import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class Peoples {

    public Peoples() {
    }

    @XmlElement(name = "people")
    private List<People> peoples = new LinkedList<>();

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }
}
