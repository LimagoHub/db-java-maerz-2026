package model;

import persistence.PersonenRepository;

import java.util.Collections;
import java.util.List;

public class PersonenVerwaltung {

    private final PersonenRepository repository;
    private final List<Person> personen;
    public PersonenVerwaltung(PersonenRepository repository) {
        this.repository = repository;
        this.personen = repository.findAll();
    }

    public List<Person> getPersonen() {
        return Collections.unmodifiableList(personen);
    }

    public void addPerson(Person person){
        personen.add(person);
    }
}
