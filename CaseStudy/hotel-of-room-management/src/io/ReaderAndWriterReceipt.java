package io;

import models.Receipt;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReaderAndWriterReceipt {
    public void writeFile(List<Receipt> receiptList) {
        File file = new File("F:\\Module2\\CaseStudy\\hotel-of-room-management\\src\\fileCSV\\receipts.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Receipt receipt: receiptList) {
                bufferedWriter.write(receipt.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Write file receipt success");
        } catch (IOException e) {
            System.err.println("File does not exist");
        }
    }

    public List<Receipt> readFile() {
        List<Receipt> newReceiptList = new ArrayList<>();
        File file = new File("F:\\Module2\\CaseStudy\\hotel-of-room-management\\src\\fileCSV\\receipts.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arrStr = str.split(",");
                String nameRoom = arrStr[0];
                int priceRoom = Integer.parseInt(arrStr[1]);
                String idReceipt = arrStr[2];

                Date startTime = null;
                try {
                    startTime = new SimpleDateFormat("dd/MM/yyyy").parse(arrStr[3]);
                } catch (Exception e) {
                    System.err.println("Error at format of birthday(dd/MM/yyyy)");
                }

                Date endTime = null;
                try {
                    endTime = new SimpleDateFormat("dd/MM/yyyy").parse(arrStr[4]);
                } catch (Exception e) {
                    System.err.println("Error at format of birthday(dd/MM/yyyy)");
                }

                String rentalStaffName = arrStr[5];
                String customerName = arrStr[6];
                String statusReceipt = arrStr[7];

                newReceiptList.add(new Receipt(nameRoom, priceRoom, idReceipt, startTime, endTime, rentalStaffName, customerName, statusReceipt));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("Read file receipt success");
        } catch (IOException e) {
            System.err.println("File does not exist");
        }
        return newReceiptList;
    }
}
