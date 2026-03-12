package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Main().run();
    }

    private void run() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(8);
        for(int i = 0; i < 8; i++) {
            service.execute(this::workerMethod);
        }
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void workerMethod() {
        try {
            Thread.sleep((long) (Math.random() * 2000));
            System.out.println(Thread.currentThread().getId() + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    class Worker implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep((long) (Math.random() * 2000));
                System.out.println(Thread.currentThread().getId() + " finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}