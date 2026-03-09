package main;


import de.db.geometrie.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
       Punkt p;
       Kreis k;

       k = new Kreis();
       p = k;

       switch(p) {
           case Kreis kreis: System.out.println("Kreis"); break;
           case Punkt punkt: System.out.println("Punkt"); break;

       }




    }
}
