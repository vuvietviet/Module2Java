package com.codegym;

public class Student {
    private String name = "John";
    private String classes = "CO2";

    public Student() {
    }

    public String  setName(String name) {
        this.name = name;
        return name;
    }

    public String setClasses(String classes) {
        this.classes = classes;
        return classes;
    }
}
