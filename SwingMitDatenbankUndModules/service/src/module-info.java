import repo.Person;
import service.PersonenServices;
import service.impl.PersonenServiceImpl;

module service {
    requires transitive persistence;

    exports service;

    uses PersonenServices;
    provides PersonenServices with PersonenServiceImpl;
}