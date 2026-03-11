package main;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        new Main().run();

    }

    private void run() {


        var liste = List.of("1", "2", "3", "4", "5");
/*
        var start = Instant.now();
        IntStream myIntStream = IntStream.rangeClosed(1,1_000_000);
        myIntStream.parallel().filter(this::isPrime).sequential().sorted().forEach(System.out::println);
        var end = Instant.now();
        var duration = Duration.between(start, end);
        System.out.printf("Duration = %s millis\n", duration.toMillis());

*/
        System.out.println( liste.stream()
                .mapToInt(Integer::parseInt).sum());
    }


    boolean isPrime(final int possiblePrime){
        for(int i=2;i<=possiblePrime/2;i++){
            if(possiblePrime%i==0){
                return false;
            }
        }


        return true;
    }

    boolean isBlabla(String x) {
        return x.endsWith("ei");
    }
}


