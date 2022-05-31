package io;

import models.HocVien;
import models.Lop;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReaderAndWriterObj {
    public void writeFile(List<HocVien> hocVienList) {
        File file = new File("listOfStudentsObj.csv");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hocVienList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.err.println("IOException!");
        }
    }

    public List<HocVien> reader(List<Lop> lopList) {
        List<HocVien> hocVienList = new ArrayList<>();
        File file = new File("listOfStudentsObj.csv");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            hocVienList = (List<HocVien>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("File not found");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return hocVienList;
    }
}
