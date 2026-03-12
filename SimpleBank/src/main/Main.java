package main;

import bank.Angestellter;
import bank.Bank;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println("Kontostand vorher");
        bank.kontostand();

        Angestellter angestellter1 =  new Angestellter(bank, 0, 1, 20);
        Angestellter angestellter2 =  new Angestellter(bank, 1, 2, 20);
        Angestellter angestellter3 =  new Angestellter(bank, 2, 0, 20);

        angestellter1.start();
        angestellter2.start();
        angestellter3.start();
    }
}
