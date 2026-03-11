package main;

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
       StringBuilder stringBuffer = new StringBuilder("Hallo");

       Instant start = Instant.now();

       for(int i = 0; i < 2_000_000; i++) {
           stringBuffer.append( "a");
       }
       String s = stringBuffer.toString();
        Instant end = Instant.now();

        System.out.println( "Dauer: " + (Duration.between(start, end).toMillis()));
    }
}

class Schwein {
    String name;
    int gewicht;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schwein{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gewicht=").append(gewicht);
        sb.append('}');
        return sb.toString();
    }
}
