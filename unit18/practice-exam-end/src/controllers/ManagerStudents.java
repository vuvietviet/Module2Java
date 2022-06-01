package controllers;

import io.ReaderAndWriter;
import models.Students;
import sort.ScoreDecrease;
import sort.ScoreIncrease;
import validate.ValidateStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManagerStudents {
    Scanner sc = new Scanner(System.in);
    ReaderAndWriter readerAndWriter = new ReaderAndWriter();
    ValidateStudent validateStudent = new ValidateStudent();
    List<Students> studentsList = readerAndWriter.readFile();
    public void menu() {
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN-------");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách sinh viên");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi từ file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                showList();
                break;
            case 2:
                add();
                break;
            case 3:
                edit();
                break;
            case 4:
                delete();
                break;
            case 5:
                sort();
                break;
            case 6:
                showReadFile(readerAndWriter.readFile());
                break;
            case 7:
                readerAndWriter.writeFile(studentsList);
                break;
            case 8:
                System.exit(0);
                break;
        }
    }

    public Students createStudent() {
        String codeStudent = validateStudent.validateCodeStudent(studentsList);
        String nameStudent = validateStudent.validateString("name :");
        int age = validateStudent.validateAge();
        String gender = validateStudent.validateString("gender :");
        String address = validateStudent.validateString("address :");
        double scoreMedium = validateStudent.validateScore();

        return new Students(codeStudent,nameStudent,age,gender,address,scoreMedium);
    }

    public void add() {
        studentsList.add(createStudent());
    }

    public void showList() {
        for (int i = 0; i < studentsList.size(); i++) {
            if ((i+1) % 5 == 0) {
                System.out.println(studentsList.get(i));
                sc.nextLine();
            } else {
                System.out.println(studentsList.get(i));
            }
        }
    }

    public void edit() {
        System.out.println("Nhập mã sinh viên cần sửa:");
        String codeStudent = sc.nextLine();
        for (int i = 0; i < studentsList.size(); i++) {
            if(studentsList.get(i).getCodeStudent().equals(codeStudent)) {
                studentsList.remove(i);
                add();
                break;
            } else if (i == studentsList.size() - 1){
                System.out.println("Không tìm được sinh viên với mã sinh viên trên.");
                edit();
                break;
            } else if (codeStudent.equals("")) {
                break;
            }
        }
    }

    public void delete() {
        System.out.println("Nhập mã sinh viên cần xóa:");
        String codeStudent = sc.nextLine();
        for (int i = 0; i < studentsList.size(); i++) {
            if(studentsList.get(i).getCodeStudent().equals(codeStudent)) {
                System.out.println("Nhấn 'Y' để xóa");
                System.out.println("Nhấn phím còn lại để hủy");
                String check = sc.nextLine();
                if (check.equals("Y")) {
                    studentsList.remove(i);
                    break;
                } else {
                    break;
                }
            } else if (i == studentsList.size() - 1){
                System.out.println("Không tìm được sinh viên với mã sinh viên trên.");
                delete();
                break;
            } else if (codeStudent.equals("")) {
                break;
            }
        }
    }

    public void sort() {
        System.out.println("-----Sắp xếp sinh viên theo điểm trung bình----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Sắp xếp điểm trung bình tăng dần");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần");
        System.out.println("3. Thoát");
        System.out.println("Chọn chức năng: ");
        int choice1 = Integer.parseInt(sc.nextLine());
        switch (choice1) {
            case 1:
                studentsList.sort(new ScoreIncrease());
                for (Students student: studentsList) {
                    System.out.println(student);
                }
                break;
            case 2:
                studentsList.sort(new ScoreDecrease());
                for (Students student: studentsList) {
                    System.out.println(student);
                }
                break;
            case 3:
                break;
        }
    }

    public void showReadFile(List<Students> list) {
        for (Students student: list) {
            System.out.println(student);
        }
    }
}
