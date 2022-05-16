package com.codegym;

public class Rectangle implements Resizeable{
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.width * this.length;
    }

    @Override
    public void resize(double percent) {
        this.width += this.width*percent/100;
        this.length += this.length*percent/100;
    }

    @Override
    public String toString() {
        return "width = " + this.width + ", length = " +
                this.length + ", area = " + getArea();
    }
}
