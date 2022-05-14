package com.codegym;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);

        point2D = new Point2D(2,2);
        System.out.println(point2D);

        System.out.println("------------------");

        Point3D point3D = new Point3D();
        System.out.println(point3D);

        point3D = new Point3D(2,3,4);
        System.out.println(point3D);
    }
}
