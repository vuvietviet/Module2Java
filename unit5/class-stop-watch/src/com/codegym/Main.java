package com.codegym;

public class Main {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        System.out.println("Start time: " + sw.getStartTime());
        System.out.println("End time: " + sw.getEndTime());
        System.out.println("Elapsed time: " + sw.getElapsedTime());
        System.out.println("-------------------");

        long[] arr = new long[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long) (Math.random() * 100000);
        }

        sw.start();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    long temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (long ele: arr) {
            System.out.print(ele + "\t");
        }
        sw.stop();

        System.out.println("\nElapsed time of funtion sort 100000 numbers is: " + sw.getElapsedTime());
    }
}
