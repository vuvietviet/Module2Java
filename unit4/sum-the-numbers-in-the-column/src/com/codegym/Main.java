package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int size1 = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int size2 = sc.nextInt();
        int[][] arr = new int[size1][size2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("Enter element in row(%d) column(%d) is: ",i,j);
                int num = sc.nextInt();
                arr[i][j] = num;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        long sum = 0;
        System.out.println("What column do you want to sum? ");
        int col = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
           sum += arr[i][col - 1];
        }

        System.out.printf("Sum of %dnd is: ",col);
        System.out.print(sum);
    }
}
