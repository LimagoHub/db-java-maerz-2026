package main;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        int x = 10;


        Supplier<Integer> mySupplier = supplierFactory();





        System.out.println(mySupplier.get());

    }

    Supplier<Integer> supplierFactory() {
        int x = 10;
        return () -> {return 10 + x;};
    }



    void Foo(String x) {
        System.out.println(x);
    }
    int sinnDesLebens() {
        return 42;
    }
}


