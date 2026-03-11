package main;

import tiere.Schwein;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Comparator<Schwein> comp = Comparator.comparingInt(Schwein::getGewicht).thenComparing(Schwein::getName);
        //Comparator<Schwein> comp = Comparator.naturalOrder();
        var set = new TreeSet<Schwein>(comp);
        set.add(new Schwein("Piggy", 10));
        set.add(new Schwein("Piggy", 10));
        set.add(new Schwein("Babe", 12));
        set.add(new Schwein("Rudi Ruessel", 9));
        set.add(new Schwein("Frederick", 10));
        set.add(new Schwein("Frederick", 11));

        for (var s : set) {
            System.out.println(s);
        }



    }
}

class MyComparator implements Comparator<Schwein> {

    @Override
    public int compare(final Schwein schwein1, final Schwein schwein2) {
        return schwein1.getName().compareTo(schwein2.getName());
    }
}
