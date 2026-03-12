package main;

import threaddemo.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        try {
            MyThread hund = new MyThread("Wau");
            MyThread katze = new MyThread("Miau");
            MyThread maus = new MyThread("Piep");

           /* Thread t1 = new Thread(hund);
            Thread t2 = new Thread(katze);
            Thread t3 = new Thread(maus);

            t1.start();
            t2.start();
            t2.join();
            t3.start();*/

            ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(3);
            executor.execute(hund);
            executor.execute(katze);
            executor.execute(maus);
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.DAYS);

        } catch (Exception e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
