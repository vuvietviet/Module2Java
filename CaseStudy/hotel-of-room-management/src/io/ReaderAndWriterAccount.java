package io;

import models.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriterAccount {
    public void writeFile(List<Account> accountList) {
        File file = new File("F:\\Module2\\CaseStudy\\hotel-of-room-management\\src\\fileCSV\\accounts.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Account account: accountList) {
                bufferedWriter.write(account.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Write file account success");
        } catch (IOException e) {
            System.err.println("File does not exist");
        }
    }

    public List<Account> readFile() {
        List<Account> newAccountList = new ArrayList<>();
        File file = new File("F:\\Module2\\CaseStudy\\hotel-of-room-management\\src\\fileCSV\\accounts.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arrStr = str.split(",");
                String accountName = arrStr[0];
                String passWord = arrStr[1];
                String numberPhone = arrStr[2];
                String address = arrStr[3];
                String email = arrStr[4];
                int age = Integer.parseInt(arrStr[5]);
                String userName = arrStr[6];
                newAccountList.add(new Account(accountName,passWord,numberPhone,address,email,age,userName));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("Read file account success");
        } catch (IOException e) {
            System.err.println("File does not exist");
        }
        return newAccountList;
    }
}
