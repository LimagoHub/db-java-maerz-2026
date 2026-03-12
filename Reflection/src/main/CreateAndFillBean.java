package main;

import java.lang.reflect.Method;
import java.util.Scanner;

public class CreateAndFillBean {

    private static final String PREFIX = "set";

    public Object createBean(final String fullQualifiedClassName) {
        try(Scanner scanner = new Scanner(System.in)) {
            final Object object = Class.forName(fullQualifiedClassName).getConstructor().newInstance();
            final Method [] methods = object.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().startsWith(PREFIX)) {
                    System.out.println("Bitte Wert fuer " + method.getName().substring(PREFIX.length()) + " eingeben: ");
                    method.invoke(object, scanner.nextLine());
                }
            }
            return object;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
