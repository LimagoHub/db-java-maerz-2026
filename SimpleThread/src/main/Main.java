package main;

import threaddemo.MyThread;

public class Main {

    public static void main(String[] args) {
        try {
            MyThread hund = new MyThread("Wau");
            MyThread katze = new MyThread("Miau");
            MyThread maus = new MyThread("Piep");

            Thread t1 = new Thread(hund);
            Thread t2 = new Thread(katze);
            Thread t3 = new Thread(maus);

            t1.start();
            t2.start();
            t2.join();
            t3.start();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
