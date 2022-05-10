package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();

        if (a == 0 || b == 0) {
            System.out.print("No greatest common factor");
        }

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b-a;
            }
        }
        System.out.print("Greatest common factor: " + a);
    }
}