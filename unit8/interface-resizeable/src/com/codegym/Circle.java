package com.codegym;

public class Circle implements Resizeable{
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public void resize(double percent) {
        this.radius += this.radius*percent/100;
    }

    @Override
    public String toString() {
        return "radius = " + this.radius + ", area = " + getArea();
    }
}
