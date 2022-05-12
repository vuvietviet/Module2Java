package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        System.out.println("Equation: " + a + "x^2 + " + b + "x + " + c + " = 0");
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        double delta = quadraticEquation.getDiscriminant();
        System.out.println("Delta is: " + delta);
        if (delta > 0) {
            System.out.println("The equation has 2 root is: " + quadraticEquation.getRoot1() +", " + quadraticEquation.getRoot2());
        } else if (delta == 0) {
            System.out.println("The equation has double root is: " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }

    }
}
