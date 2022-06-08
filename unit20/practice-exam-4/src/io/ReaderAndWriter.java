package io;

import models.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    public void writeFile(List<Products> productsList) {
        File file = new File("ProductList.csv");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productsList);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Ghi file thành công");
        } catch (IOException e) {
            System.err.println("Lỗi đọc ghi file");;
        }
    }

    public List<Products> readFile() {
        List<Products> newProductList = new ArrayList<>();
        File file = new File("ProductList.csv");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            newProductList = (List<Products>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("Đọc file thành công");
        } catch (IOException e) {
            System.err.println("Không tìm thấy file");
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi thực thi");;
        }
        return newProductList;
    }
}
