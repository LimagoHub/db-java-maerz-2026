package service;

import persistence.Person;

import java.util.List;

public interface PersonenServices {

    void addPerson(Person person);
    List<Person> getPersonen();

    static PersonenServices getInstance(){
        return new service.impl.PersonenServiceImpl();
    }
}
