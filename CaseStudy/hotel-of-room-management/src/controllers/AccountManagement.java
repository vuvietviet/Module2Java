package controllers;

import io.ReaderAndWriterAccount;
import models.Account;
import validate.AccountValidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManagement {
    Scanner scanner = new Scanner(System.in);
    AccountValidate accountValidate = new AccountValidate();
    ReaderAndWriterAccount readerAndWriterAccount = new ReaderAndWriterAccount();
    List<Account> accountList = readerAndWriterAccount.readFile();
    public void menuAccount() {
        System.out.println("------Menu Account-----");
        System.out.println("1. Registration");
        System.out.println("2. Log in");
        System.out.println("3. Show list of account");
        System.out.println("4. Search account");
        System.out.println("5. Check exist of account");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                registration();
                break;
            case 2:
            case 3:
                showAccountList();
                break;
            case 4:
                searchAccount();
                break;
            case 5:
                checkExistOfAccount();
                break;
        }
    }

    public void registration() {
        String accountName = accountValidate.validateAccountName(accountList);
        String passWord = accountValidate.validatePassWord();
        String numberPhone = accountValidate.validateNumberPhone();
        String address = accountValidate.validateString("address");
        String email = accountValidate.validateEmail();
        int age = accountValidate.validateAge();
        String userName = accountValidate.validateString("user name");

        accountList.add(new Account(accountName,passWord,numberPhone,address,email,age,userName));

        readerAndWriterAccount.writeFile(accountList);
        System.out.println("Register account success!");
    }

    public void logIn() {
        System.out.println("Input account name:");
        String accountName = scanner.nextLine();
        System.out.println("Input password:");
        String passWord = scanner.nextLine();
        for (Account ac: accountList) {
            if (ac.getAccountName().equals(accountName) && ac.getPassWord().equals(passWord)) {
                // menu chức năng
            } else if (ac.equals(accountList.get(accountList.size() - 1))) {
                System.out.println("Not found account");
            }
        }
    }

    public void showAccountList() {
        for (Account ac: accountList) {
            System.out.println(ac);
        }
    }

    public void searchAccount() {
        List<Account> newAccountList = new ArrayList<>();
        System.out.println("Input user name:");
        String userName = scanner.nextLine();
        for (Account ac: accountList) {
            if (ac.getUseName().equals(userName)) {
                newAccountList.add(ac);
            }
        }

        try {
            for (Account ac: newAccountList) {
                System.out.println(ac);
            }
        } catch (Exception e) {
            System.err.println("Not found " + userName);
        }
    }

    public void checkExistOfAccount() {
        System.out.println("Input user name:");
        String userName = scanner.nextLine();
        String display = "Not exist";
        for (Account ac: accountList) {
            if (ac.getUseName().equals(userName)) {
                display =  "Existing";
            }
        }
        System.out.println(display);
    }
}