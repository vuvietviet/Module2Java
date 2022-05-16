package com.codegym;

public class Test {
    public static void main(String[] args) {
        Resizeable[] arr = new Resizeable[3];
        arr[0] = new Circle();
        arr[1] = new Rectangle();
        arr[2] = new Square();

        System.out.println("Pre-up:");
        for (Resizeable re: arr) {
            System.out.println(re);
        }

        arr[0].resize(10);
        arr[1].resize(50);
        arr[2].resize(100);
        System.out.println("After-up:");
        for (Resizeable re: arr) {
            System.out.println(re);
        }
    }
}
