package main;

public class Main {

    public static void main(String[] args) {
        new B();
        new B();
        //ABFoovonBDBFoovonBD
    }
}

class A {
    static {
        System.out.println("A");
    }

    public A() {
        System.out.println("B");
        foo();
    }

    public void foo() {
        System.out.println("Foo von A");
    }
}

class B extends A {
    public B() {
        System.out.println("D");
    }

    @Override
    public void foo() {
        System.out.println("Foo von B");
    }
}
