package service.impl;

import repo.Person;
import repo.PersonRepository;
import service.PersonenServices;

import java.util.Collections;
import java.util.List;

public class PersonenServiceImpl  implements PersonenServices {

    private final PersonRepository repo = PersonRepository.getInstance();
    private final List<Person> personen;

    public PersonenServiceImpl() {
        this.personen = repo.findAll();
    }

    @Override
    public void addPerson(final Person person) {
        // Fachliche Pruefung
        personen.add(person);
    }

    @Override
    public List<Person> getPersonen() {
        return Collections.unmodifiableList(personen);
    }


}
