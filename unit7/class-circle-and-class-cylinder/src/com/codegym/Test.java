package com.codegym;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(2.0,"black");
        System.out.println(circle);

        System.out.println("------------------");

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(3);
        System.out.println(cylinder);

        cylinder = new Cylinder(5,3,"orange");
        System.out.println(cylinder);
    }
}
