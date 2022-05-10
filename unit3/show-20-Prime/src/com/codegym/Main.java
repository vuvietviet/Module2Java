package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter first number of primes: ");
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.printf("First %d prime numbers: ", num);
        int i = 2;

        while (count < num) {
          if (isPrimeNumber(i)) {
              System.out.print(i + " ");
              count++;
          }
          i++;
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
