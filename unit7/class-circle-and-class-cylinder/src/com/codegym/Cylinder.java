package com.codegym;

public class Cylinder extends Circle{
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return 2 * Math.PI * getRadius() * (getRadius() + height);
    }

    public double getVolume() {
        return getRadius() * getRadius() * Math.PI * height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height = " +
                getHeight() + ", which is a subclass of " +
                super.toString();
    }
}
