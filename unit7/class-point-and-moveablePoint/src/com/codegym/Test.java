package com.codegym;

public class Test {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        point = new Point(1,1);
        System.out.println(point);

        System.out.println("--------------------");

        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);

        moveablePoint = new MoveablePoint(5,5);
        System.out.println(moveablePoint);

        moveablePoint = new MoveablePoint(2,2,3,3);
        System.out.println(moveablePoint);

        System.out.println(moveablePoint.move());
    }
}
