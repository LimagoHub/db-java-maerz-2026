package persistence;

import persistence.impl.PersonenRepositoryImpl;

import java.util.List;

public interface PersonRepository {


    List<Person> findAll();

    static PersonRepository getInstance(){
        return new PersonenRepositoryImpl();
    }
}
