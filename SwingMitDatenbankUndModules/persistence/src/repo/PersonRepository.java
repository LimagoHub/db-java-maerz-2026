package repo;



import repo.impl.PersonenRepositoryImpl;

import java.util.List;
import java.util.ServiceLoader;

public interface PersonRepository {


    List<Person> findAll();

    static PersonRepository getInstance(){
        final ServiceLoader<PersonRepository> loader = ServiceLoader.load(PersonRepository.class);

        return loader.findFirst().get();
    }
}
