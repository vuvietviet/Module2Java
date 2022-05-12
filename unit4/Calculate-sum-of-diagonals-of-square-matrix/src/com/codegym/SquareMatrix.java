package com.codegym;

import java.util.Scanner;

public class SquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of columns(rows): ");
        int size = sc.nextInt();
        int[][] arr = new int[size][size];

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

        long sumTop = 0;
        for (int i = 0; i < arr.length; i++) {
            sumTop += arr[i][i];
        }
        System.out.println("The sum of diagonals of top is: " + sumTop);

        long sumBottom = 0;
        for (int i = 0; i < arr.length; i++) {
            sumBottom += arr[i][arr.length -1 -i];
        }
        System.out.println("The sum of diagonals of bottom is: " + sumBottom);
    }
}
