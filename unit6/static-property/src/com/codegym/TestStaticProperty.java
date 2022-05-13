package com.codegym;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3","Skyactiv 6");
        System.out.println(Car.numberOfCars);
    }
}
