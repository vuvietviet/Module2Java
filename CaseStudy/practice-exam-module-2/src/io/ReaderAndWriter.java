package io;

import models.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    public void writeFile(List<Products> productsList) {
        File file = new File("ProductListOfExam.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("MÃ SẢN PHẨM,TÊN SẢN PHẨM,GIÁ,SỐ LƯỢNG,MÔ TẢ");
            bufferedWriter.newLine();
            for (Products product: productsList) {
                bufferedWriter.write(product.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Ghi file thành công");
        } catch (IOException e) {
            System.err.println("Lỗi đọc ghi file");
        }
    }

    public List<Products> readFile() {
        List<Products> newProductList = new ArrayList<>();
        File file = new File("ProductListOfExam.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] arrStr = str.split(",");
                String id = arrStr[0];
                String name = arrStr[1];
                double price = Double.parseDouble(arrStr[2]);
                int amount = Integer.parseInt(arrStr[3]);
                String detail = arrStr[4];

                newProductList.add(new Products(id,name,price,amount,detail));
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("Đọc file thành công");
        } catch (IOException e) {
            System.err.println("Không tìm thấy file");
        }
        return newProductList;
    }
}
