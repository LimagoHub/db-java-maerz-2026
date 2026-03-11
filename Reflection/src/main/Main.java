package main;

import tiere.Schwein;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        CreateAndFillBean createAndFillBean = new CreateAndFillBean();
        Object object = createAndFillBean.createBean("pojo.Person");
        System.out.println(object);
        
        /*try {
            Class clazz;

            // 1. Weg
            clazz = Schwein.class;

            // 2. Weg
            clazz = new Schwein().getClass();

            // 3. Weg
            clazz = Class.forName("tiere.Schwein");

            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());

            System.out.println("----------------------------------------------------");

            Method [] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            System.out.println("----------------------------------------------------");
            methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
            System.out.println("----------------------------------------------------");

            Object obj = clazz.getConstructor().newInstance();
            System.out.println(obj);

            Method method = clazz.getMethod("fuettern");
            method.invoke(obj);
            System.out.println(obj);

            method = clazz.getMethod("setName", String.class);
            method.invoke(obj, "Max");
            System.out.println(obj);

            method = clazz.getDeclaredMethod("setGewicht",  int.class);
            method.setAccessible(true);
            method.invoke(obj, -100);
            System.out.println(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
         */
    }
}
