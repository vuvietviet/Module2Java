package com.codegym;

import java.util.Scanner;

public class Main {
    static int[] arr = {2, 6, 4, 8, 0, 3};

    public static void main(String[] args) {
            System.out.print("The first array: ");
            for (int ele : arr) {
                System.out.print(ele + "\t");
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter a number: ");
            int x = sc.nextInt();
            for (int i = 0; i < arr.length; i++) {
                if (x == arr[i]) {
                    delArr(i, x);
                    break;
                }
                if (i == arr.length - 1) {
                    System.out.println("Number does not exist in array");
                }
            }
    }
     public static void delArr(int index, int x) {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < arr.length-1; i++) {
                if (i < index) {
                    newArr[i] = arr[i];
                }
                if (i >= index) {
                    newArr[i] = arr[i + 1];
                }
            }
            System.out.printf("The array after delete element %d is: ",x);
         for (int i = 0; i < newArr.length; i++) {
             System.out.print(newArr[i] + "\t");
         }
     }

}
