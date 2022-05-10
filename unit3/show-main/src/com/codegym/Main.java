package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle");
                    System.out.println("Enter number of rows: ");
                    int row = input.nextInt();
                    System.out.println("Enter number of columns: ");
                    int col = input.nextInt();
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Print the square triangle");
                    System.out.println("Enter 1: the corner is square at top-left,");
                    System.out.println("Enter 2: the corner is square at top-right,");
                    System.out.println("Enter 3: the corner is square at bottom-left,");
                    System.out.println("Enter 4: the corner is square at bottom-right.");
                    int corner = input.nextInt();
                    if (corner == 1) {
                        for (int i = 0; i < 6; i++) {
                            for (int j = 6 - i; j > 0 ; j--) {
                                System.out.print("* ");
                            }
                            System.out.print("\n");
                        }
                    } else if (corner == 2) {
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j <= i; j++) {
                                System.out.print("  ");
                            }
                            for (int k = 6-i; k > 0; k--) {
                                System.out.print("* ");
                            }
                            System.out.print("\n");
                        }
                    } else if (corner == 3) {
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j <= i; j++) {
                                System.out.print("* ");
                            }
                            System.out.print("\n");
                        }
                    } else if (corner == 4) {
                        for (int i = 0; i < 6; i++) {
                            for (int j = 6 - i; j > 0 ; j--) {
                                System.out.print("  ");
                            }
                            for (int k = 0; k <= i; k++) {
                                System.out.print("* ");
                            }
                            System.out.print("\n");
                        }
                    } else {
                        System.out.print("No the square triangle");
                    }

                    break;
                case 3:
                    System.out.println("Print isosceles triangle");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 6 - i; j > 0 ; j--) {
                            System.out.print(" ");
                        }
                        for (int k = 0; k <= i; k++) {
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
