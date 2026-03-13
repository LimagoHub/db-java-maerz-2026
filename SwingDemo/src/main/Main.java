package main;

import persistence.PersonenRepository;

public class Main {
    public static void main(String[] args) {
        PersonenRepository repository = new PersonenRepository();
        repository.findAll().forEach(System.out::println);
    }
}
