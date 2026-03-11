package main;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*

        Lest solange Worter von der Console ein (Schleife) bis das Wort "stop" eingegeben wird.
        Speichert die Wörter in einer geeigneten Struktur.
        Das Wort "stop" wird nicht gespeichert.

        Danach eine Ausgabeschleife die die Werte in der gleichen Reihenfolge ausgibt.


         */

        try(Scanner scanner = new Scanner(System.in)){

            System.out.println("Bitte geben Sie ein Wort ein: ");

            String wort = scanner.nextLine();

            System.out.println("Hallo: " + wort + "");
        }




    }
}
