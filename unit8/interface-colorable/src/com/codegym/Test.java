package com.codegym;

public class Test {
    public static void main(String[] args) {
        Shape[] arr = new Shape[4];
        arr[0] = new Square();
        arr[1] = new Circle();
        arr[2] = new Square("black", false, 4);
        arr[3] = new Circle("yellow", false, 2);

        for (Shape s: arr) {
            if (s instanceof Colorable) {
                ((Colorable) s).howToColor();
            }
            System.out.println(s);
            System.out.println("---------------");
        }
    }
}
