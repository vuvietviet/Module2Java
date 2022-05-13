package com.codegym;

import java.util.Scanner;

public class ManagerEmployee {
    Employee[] employees = new Employee[0];
    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("Menu");
        System.out.println("1. Add");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. Show");
        System.out.println("5. Exit");

        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                editByIndex();
                break;
            case 3:
                delete();
                break;
            case 4:
                show();
                break;
            case 5:
                System.exit(0);
        }
    }

    public Employee create() {
        System.out.println("Input ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Input Name: ");
        String name = sc.nextLine();
        System.out.println("Input Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input Address: ");
        String address = sc.nextLine();

        Employee employee = new Employee(id, name, age, address);

        return employee;
    }

    public void add() {
        Employee[] newEmployee = new Employee[employees.length + 1];
        for (int i = 0; i < employees.length; i++) {
            newEmployee[i] = employees[i];
        }
        newEmployee[newEmployee.length - 1] = create();
        employees = newEmployee;
    }
    public void editByIndex() {
        System.out.println("Enter the position to edit: ");
        int index = Integer.parseInt(sc.nextLine());

        employees[index] = create();
    }

    public void delete() {
        System.out.println("Enter the position to delete: ");
        int index = Integer.parseInt(sc.nextLine());
        Employee[] newEmployee = new Employee[employees.length - 1];
        for (int i = 0; i < employees.length - 1; i++) {
            if (i < index) {
                newEmployee[i] = employees[i];
            } else {
                newEmployee[i] = employees[i + 1];
            }
        }
        employees = newEmployee;
    }

    public void show() {
        for (Employee ele: employees) {
            System.out.println(ele.toString());
        }
    }
}
