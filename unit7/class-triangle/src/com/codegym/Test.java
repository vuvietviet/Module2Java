package com.codegym;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("black",true);
        System.out.println(shape);

        System.out.println("------------------");

        Scanner sc = new Scanner(System.in);
        Triangle triangle = new Triangle();
        System.out.println(triangle);

        triangle = new Triangle(2,3,4);
        System.out.println(triangle);

        System.out.println("-----------------");
        do {
            System.out.println("Enter the length of three side of triangle:");
            System.out.print("side1: ");
            double side1 = Double.parseDouble(sc.nextLine());
            triangle.setSide1(side1);

            System.out.print("side2: ");
            double side2 = Double.parseDouble(sc.nextLine());
            triangle.setSide2(side2);

            System.out.print("side3: ");
            double side3 = Double.parseDouble(sc.nextLine());
            triangle.setSide3(side3);

            System.out.print("color: ");
            String color = sc.nextLine();
            triangle.setColor(color);

            if (side1 + side2 > side3 &&
                    side1 + side3 > side2 &&
                    side2 + side3 > side1) {
                System.out.println(triangle);
                break;
            } else {
                System.out.println("Not the length of three side of triangle");
            }
        } while (true);

    }
}
