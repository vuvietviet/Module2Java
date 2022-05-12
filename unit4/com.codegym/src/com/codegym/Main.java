package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "Raising the bar";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character: ");
        String c = sc.nextLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (c.charAt(0) == str.charAt(i)) {
                count++;
            }
        }
         if (count > 0) {
             System.out.printf(" The character %s in the string appears %d times", c, count);
         } else {
             System.out.println("The character %s does not exist in the string");
         }
    }
}
