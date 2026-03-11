package main;

import java.util.*;
import java.util.function.BiFunction;
import static java.util.Map.*;
public class Main {
    public static void main(String[] args) {

        new Main() .run();

    }

    public void run() {
        Map<String, Map<String, Double>> planeten = new HashMap<>();

        Map<String, Double> mars = new HashMap<>();
        mars.put("temperatur", 30.0);
        mars.put("luftfeuchtigkeit", 10.0);
        mars.put("sonderwert", 100.0);
        planeten.put("mars", mars);


        planeten.put("venus", Map.ofEntries(entry("temp", 20.0), entry("feuchte", 40.0), entry("sonderwert", 100.0)));


        planeten.forEach(this::print);
    }

    private void print(String planet, Map<String, Double> eigenschaften) {
        System.out.println(planet + ": ");
        eigenschaften.forEach((key, value) -> System.out.println("\t" + key + ": " + value)); {}
    }

}
