package com.codegym;

public class Square implements Resizeable{
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public void resize(double percent) {
        this.side += this.side*percent / 100;
    }

    @Override
    public String toString() {
        return "side = " + this.side + ", area = " + getArea();
    }
}
