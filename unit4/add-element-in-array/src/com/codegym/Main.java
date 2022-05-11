package com.codegym;

import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array: ");
        int N = sc.nextInt();
        arr = new int[N];
        System.out.print("The first array: ");
        for (int ele : arr) {
            System.out.print(ele + "\t");
        }
        System.out.print("\nEnter a number: ");
        int x = sc.nextInt();
        System.out.print("Enter position: ");
        int index = sc.nextInt();

        if (index <= -1 || index > arr.length-1) {
            System.out.print("Can't insert element in array");
        } else {
            addArr(index,x);
        }
    }

    public static void addArr(int index, int x) {
        int[] arr1 = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < index) {
                arr1[i] = arr[i];
            } else if (i == index){
                arr1[index] = x;
            } else {
                arr1[i] = arr[i - 1];
            }
        }
        System.out.printf("Array after add %d is: ",x);
        for (int ele: arr1) {
            System.out.print(ele + "\t");
        }
    }
}
