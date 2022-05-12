package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of first array: ");
        int size1 = sc.nextInt();

        System.out.print("Enter size of second array: ");
        int size2 = sc.nextInt();

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        int[] arr3 = new int[size1 + size2];

        System.out.print("Input element for first array: \n");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("Element %d is: ", (i + 1));
            int num1 = sc.nextInt();
            arr1[i] = num1;
        }
        for (int ele: arr1) {
            System.out.print(ele + "\t");
        }

        System.out.print("\nInput element for second array: \n");
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("Element %d is: ", (i + 1));
            int num2 = sc.nextInt();
            arr2[i] = num2;
        }
        for (int ele: arr2) {
            System.out.print(ele + "\t");
        }


        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length + i] = arr2[i];
        }

        System.out.print("\nArray after merge: ");
        for (int ele: arr3) {
            System.out.print(ele + "\t");
        }
    }
}
