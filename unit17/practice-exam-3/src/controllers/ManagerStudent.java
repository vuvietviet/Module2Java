package controllers;

import io.ReaderAndWriter;
import models.HocVien;
import models.Lop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
    ReaderAndWriter readerAndWriter = new ReaderAndWriter();
    Scanner sc = new Scanner(System.in);
    List<Lop> lopList = new ArrayList<>();

    List<HocVien> hocVienList = new ArrayList<>();

    public ManagerStudent() {
        lopList.add(new Lop("C1",new Date("1/1/2022"),1,20));
        lopList.add(new Lop("C2",new Date("1/2/2022"),2,20));
        lopList.add(new Lop("C3",new Date("1/3/2022"),3,20));
        hocVienList = readerAndWriter.reader(lopList);
    }

    public void menu() {
        System.out.println("Menu");
        System.out.println("1. Add student");
        System.out.println("2. Show information of student");
        System.out.println("3. Show student to class");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                createStudent();
                break;
            case 2:
                showStudents();
                break;
            case 3:
                showStudentsToClass();
                break;
        }
    }

    public void createStudent() {
        boolean check = false;
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(sc.nextLine());
        Date birthday = null;
        while (!check) {
            try {
                System.out.println("Input birthday:");
                birthday = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
                check = true;
            } catch (Exception e) {
                System.err.println("Error at format of birthday(dd/MM/yyyy)");
            }
        }
        System.out.println("Input number phone:");
        String numberPhone = sc.nextLine();
        System.out.println("Input address:");
        String address = sc.nextLine();
        showClass();
        System.out.println("Select class:");
        String choice1 = sc.nextLine();
        switch (choice1) {
            case "C1":
                hocVienList.add(new HocVien(name,age,birthday,numberPhone,address,lopList.get(0)));
                break;
            case "C2":
                hocVienList.add(new HocVien(name,age,birthday,numberPhone,address,lopList.get(1)));
                break;
            case "C3":
                hocVienList.add(new HocVien(name,age,birthday,numberPhone,address,lopList.get(2)));
                break;
        }
        readerAndWriter.writeFile(hocVienList);
    }

    public void showClass() {
        for (Lop ele: lopList) {
            System.out.println(ele);
            System.out.println();
        }
    }

//    public List<Lop> createClass() {
//        List<Lop> lopList = new ArrayList<>();
//        lopList.add(new Lop("C1",new Date("1/1/2022"),1,20));
//        lopList.add(new Lop("C2",new Date("1/2/2022"),2,20));
//        lopList.add(new Lop("C3",new Date("1/3/2022"),3,20));
//        return lopList;
//    }

    public void showStudents() {
        for (HocVien ele: hocVienList) {
            System.out.println(ele);
            System.out.println();
        }
    }

    public void showStudentsToClass() {
        List<HocVien> list = new ArrayList<>();
        System.out.println("Enter name of class:");
        String nameClass = sc.nextLine();
        for (int i = 0; i < hocVienList.size(); i++) {
            if ((hocVienList.get(i).getLop().getNameClass()).equals(nameClass)) {
                list.add(hocVienList.get(i));
            }
        }

        for (HocVien ele: list) {
            System.out.println(ele);
            System.out.println();
        }
    }

}
