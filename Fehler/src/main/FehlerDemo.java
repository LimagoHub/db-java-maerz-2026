package main;

import java.io.IOException;

public class FehlerDemo {

    public static void main(String[] args) {


        try {
            int feld [] = new int[2];
            int a, b, c;
            a = b = 0;

            fehlerMethode();
            throw new ArithmeticException("a ist null");
            //c = a / b;
            //feld[1000] = 3;

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unbekannter Fehler");
        }


        System.out.println("Sie haben ein kleines Programm echt gluecklich gemacht");


    }

    static void fehlerMethode() throws IOException {
        throw new IOException("Fehler");
    }


}

