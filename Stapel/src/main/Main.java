package main;

import de.db.collections.Stapel;
import de.db.collections.StapelException;
import geometrie.Kreis;
import geometrie.Punkt;
import tiere.Schwein;

import java.util.logging.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {


        try {
            myMethod();

        } catch (StapelException e) {
            e.printStackTrace();
        } catch (Exception e) {
            logger.severe("Dieser Fehler sollte nicht auftreten, ist er aber!!!!");
        }

    }

    private static void myMethod() throws StapelException {
        Stapel<Punkt> stapel = new Stapel<>(40);


        for(int i = 0; i < 10; i++) {
            if(!stapel.isFull()) {
                //stapel.push(new Schwein("Schwein Nr."+ i ));
                stapel.push(new Punkt(i,i ));
                stapel.push(new Kreis(i));
                //stapel.push(i);
            }
        }

        while(!stapel.isEmpty()) {
                Punkt p = stapel.pop();

                p.rechts(1);
                System.out.println(p);


        }
    }
}
