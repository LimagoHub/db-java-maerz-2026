package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("Peter", 1000);
        map.put("Paul", 2000);
        map.put("Mary", 3000);

        System.out.println(map.get("Peter"));

        map.put("Peter", 3000);

        System.out.println(map.get("Peter"));

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        for (String key : keys) {
            System.out.println(key + " = " + map.get(key) );
        }

        map.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
