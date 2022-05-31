package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.HocVien;
import models.Lop;

public class ReaderAndWriter {
    public void writeFile(List<HocVien> hocVienList) {
        File file = new File("listOfStudents.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (HocVien ele: hocVienList) {
                bw.write(ele.write());
                bw.newLine();
            }
            bw.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("IOException!");
        }
    }

    public List<HocVien> reader(List<Lop> lopList) {
        List<HocVien> hocVienList = new ArrayList<>();
        File file = new File("listOfStudents.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            String str = br.readLine();
            while (str != null) {
                String[] arrStr = str.split(",");
                String name = arrStr[0];
                int age = Integer.parseInt(arrStr[1]);
                Date birthday = new Date(arrStr[2]);
                String numberPhone = arrStr[3];
                String address = arrStr[4];
                String nameClass = arrStr[5];

                for (Lop lop: lopList) {
                    if (lop.getNameClass().equals(nameClass)) {
                        hocVienList.add(new HocVien(name,age,birthday,numberPhone,address,lop));
                        break;
                    }
                }
                str = br.readLine();
            }
            br.close();
            fileReader.close();

        } catch (IOException e) {
            System.err.println("File not found");
        }
        return hocVienList;
    }
}
