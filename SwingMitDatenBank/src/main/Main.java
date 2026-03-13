package main;

import persistence.PersonRepository;
import persistence.impl.PersonenRepositoryImpl;
import presentation.PersonenAdapter;
import presentation.PersonenMaske;
import service.PersonenServices;

public class Main {

    public static void main(String[] args) {
        new PersonenMaske().setVisible(true);
    }
}
