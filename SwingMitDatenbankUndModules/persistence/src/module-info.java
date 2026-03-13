import repo.PersonRepository;
import repo.impl.PersonenRepositoryImpl;

module persistence {
    requires java.sql;

    exports repo;
    uses PersonRepository;
    provides PersonRepository with PersonenRepositoryImpl;

}