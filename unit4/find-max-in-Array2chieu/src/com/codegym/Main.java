package com.codegym;

public class Main {
    public static void main(String[] args) {
        int[][] arr ={
                {0,2,3},
                {4,6,4},
                {8,9,5}
        };
        int max = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               if (max < arr[i][j]) {
                   max = arr[i][j];
               }
            }
        }
        System.out.printf("Max value of array is: %d", max);
    }
}
