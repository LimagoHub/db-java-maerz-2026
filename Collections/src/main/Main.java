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

        final List<String> woerter = new ArrayList<>();
        try(final Scanner scanner = new Scanner(System.in)){

            while(true) {
                System.out.println("Bitte geben Sie ein Wort ein: ");
                final String wort = scanner.nextLine();
                if(wort.equals("stop"))break;
                woerter.add(wort);
            }

            for(String wort : woerter.reversed()) {
                System.out.println(wort);
            }

            while(! woerter.isEmpty())
                System.out.println( woerter.removeLast());
        }




    }
}
