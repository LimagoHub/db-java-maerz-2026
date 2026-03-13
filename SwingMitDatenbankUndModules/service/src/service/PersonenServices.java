package service;


import repo.Person;

import java.util.List;
import java.util.ServiceLoader;

public interface PersonenServices {

    void addPerson(Person person);
    List<Person> getPersonen();

    static PersonenServices getInstance(){

        final ServiceLoader<PersonenServices> loader = ServiceLoader.load(PersonenServices.class);

        return loader.findFirst().get();
    }
}
