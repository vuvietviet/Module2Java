package io;

import models.Students;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    public void writeFile(List<Students> studentsList) {
        File file = new File("students.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Students student: studentsList) {
                bufferedWriter.write(student.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Ghi file thành công");
        } catch (IOException e) {
            System.err.println("File không tồn tại");
        }
    }

    public List<Students> readFile() {
        List<Students> newStudents = new ArrayList<>();
        File file = new File("students.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arrStr = str.split(",");
                String codeStudent = arrStr[0];
                String nameStudent = arrStr[1];
                int age = Integer.parseInt(arrStr[2]);
                String gender = arrStr[3];
                String address = arrStr[4];
                double scoreMedium = Double.parseDouble(arrStr[5]);
                newStudents.add(new Students(codeStudent,nameStudent,age,gender,address,scoreMedium));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("Đọc file thành công");
        } catch (IOException e) {
            System.err.println("File không tồn tại");
        }
        return newStudents;
    }
}
