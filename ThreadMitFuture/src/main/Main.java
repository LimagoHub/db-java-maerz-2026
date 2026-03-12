package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception{


        List<Future<Long>> futures = new ArrayList<>();

        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new MyWorker());

        for(int i = 0; i < 10; i++) {
            futures.add(service.submit(new MyCallabel()));
        }

       for(Future<Long> future : futures) {
           System.out.println(future.get());
       }
    }

    static class MyWorker implements Runnable {
        @Override
        public void run() {
            System.out.println("DoSomething");
        }
    }

    static class MyCallabel implements Callable<Long> {
        @Override
        public Long call() throws Exception {
            Thread.sleep(1000);
            return Thread.currentThread().getId();
        }
    }
}
