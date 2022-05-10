package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number need read (0 -> 999): ");

        int num = scanner.nextInt();

        if (num < 10 && num >= 0) {
            switch (num) {
                case 0: System.out.print("zero");break;
                case 1: System.out.print("one");break;
                case 2: System.out.print("two");break;
                case 3: System.out.print("three");break;
                case 4: System.out.print("four");break;
                case 5: System.out.print("five");break;
                case 6: System.out.print("six");break;
                case 7: System.out.print("seven");break;
                case 8: System.out.print("eight");break;
                case 9: System.out.print("nine");break;
            }
        } else if (num >= 10 && num < 20) {
            int num1 = num % 10;
            switch (num1) {
                case 0: System.out.print("ten");break;
                case 1: System.out.print("eleven");break;
                case 2: System.out.print("twelve");break;
                case 3: System.out.print("thirteen");break;
                case 4: System.out.print("fourteen");break;
                case 5: System.out.print("fiveteen");break;
                case 6: System.out.print("sixteen");break;
                case 7: System.out.print("seventeen");break;
                case 8: System.out.print("eighteen");break;
                case 9: System.out.print("nineteen");break;
            }
        } else if (num >= 20 && num < 100) {
            int num1 = num / 10;
            int num2 = num % 10;

            switch (num1) {
                case 2: System.out.print("twenty ");break;
                case 3: System.out.print("thirty ");break;
                case 4: System.out.print("fourty ");break;
                case 5: System.out.print("fivety ");break;
                case 6: System.out.print("sixty ");break;
                case 7: System.out.print("seventy ");break;
                case 8: System.out.print("eightty ");break;
                case 9: System.out.print("ninety ");break;
            }
            switch (num2) {
                case 1: System.out.print("one");break;
                case 2: System.out.print("two");break;
                case 3: System.out.print("three");break;
                case 4: System.out.print("four");break;
                case 5: System.out.print("five");break;
                case 6: System.out.print("six");break;
                case 7: System.out.print("seven");break;
                case 8: System.out.print("eight");break;
                case 9: System.out.print("nine");break;
            }
        } else if (num >= 100 && num < 1000) {
            int num1 = num / 100;
            int num1a = num % 100;
            int num2 = num1a / 10;
            int num3 = num1a % 10;

            switch (num1) {
                case 1: System.out.print("one hundred ");break;
                case 2: System.out.print("two hundred ");break;
                case 3: System.out.print("three hundred ");break;
                case 4: System.out.print("four hundred ");break;
                case 5: System.out.print("five hundred ");break;
                case 6: System.out.print("six hundred ");break;
                case 7: System.out.print("seven hundred ");break;
                case 8: System.out.print("eight hundred ");break;
                case 9: System.out.print("nine hundred ");break;
            }
            switch (num2) {
                case 1:
                    switch (num3) {
                        case 0: System.out.print("ten");break;
                        case 1: System.out.print("eleven");break;
                        case 2: System.out.print("twelve");break;
                        case 3: System.out.print("thirteen");break;
                        case 4: System.out.print("fourteen");break;
                        case 5: System.out.print("fiveteen");break;
                        case 6: System.out.print("sixteen");break;
                        case 7: System.out.print("seventeen");break;
                        case 8: System.out.print("eighteen");break;
                        case 9: System.out.print("nineteen");break;
                    }
                case 2: System.out.print("twenty ");break;
                case 3: System.out.print("thirty ");break;
                case 4: System.out.print("fourty ");break;
                case 5: System.out.print("fivety ");break;
                case 6: System.out.print("sixty ");break;
                case 7: System.out.print("seventy ");break;
                case 8: System.out.print("eightty ");break;
                case 9: System.out.print("ninety ");break;
            }
            switch (num3) {
                case 1: System.out.print("one");break;
                case 2: System.out.print("two");break;
                case 3: System.out.print("three");break;
                case 4: System.out.print("four");break;
                case 5: System.out.print("five");break;
                case 6: System.out.print("six");break;
                case 7: System.out.print("seven");break;
                case 8: System.out.print("eight");break;
                case 9: System.out.print("nine");break;
            }
        } else {
            System.out.print("Number need read (0 -> 999): ");
        }
    }
}
