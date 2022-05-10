package com.codegym;

public class Main {
    public static void main(String[] args) {
        System.out.print("The prime less than 100 is: ");
        int i = 2;
        while (i < 100) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
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
