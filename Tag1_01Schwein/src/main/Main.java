package main;

import tiere.Schwein;

public class Main {

    public static void main(String[] args) {

      new Main().run();
    }

    private void run() {

        System.out.println(Schwein.getCounter());

        Schwein piggy;

        piggy = new Schwein();

        System.out.println(Schwein.getCounter());
        Schwein babe = new Schwein();



        piggy.setName("Miss Piggy");
        System.out.println( piggy);

        piggy.fuettern();
        System.out.println( piggy);
    }
}
