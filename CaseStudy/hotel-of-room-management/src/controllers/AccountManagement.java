package controllers;

import io.ReaderAndWriterAccount;
import models.Account;
import validate.AccountValidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManagement {
    Scanner scanner = new Scanner(System.in);
    RoomManagement roomManagement = new RoomManagement();
    ReceiptManagement receiptManagement = new ReceiptManagement();
    AccountValidate accountValidate = new AccountValidate();
    ReaderAndWriterAccount readerAndWriterAccount = new ReaderAndWriterAccount();
    List<Account> accountList = readerAndWriterAccount.readFile();
    public void menuAccount() {
        while (true) {
            System.out.println("\n------Menu Account-----");
            System.out.println("1. Registration");
            System.out.println("2. Log in");
            System.out.println("3. Show list of account");
            System.out.println("4. Search account");
            System.out.println("5. Check exist of account");
            System.out.println("Select a number: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        registration();
                        break;
                    case 2:
                        logIn();
                        break;
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
                break;
            } catch (Exception e) {
                System.err.println("Format select");
            }

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
                System.out.println("Hello " + ac.getUseName());
                menuMain(ac);
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

    public void changePasswordAccount(Account account) {
        System.out.println("Input old password: ");
        String oldPassword = scanner.nextLine();
        if (account.getPassWord().equals(oldPassword)) {
            String newPassword = accountValidate.validatePassWord();
            account.setPassWord(newPassword);
            readerAndWriterAccount.writeFile(accountList);
            System.out.println("Change password success");
        } else {
            System.out.println("Wrong old password");
        }
    }

    public void menuMain(Account account) {
        while (true) {
            System.out.println("\n---------Menu-------");
            System.out.println("1. Show information of account");
            System.out.println("2. Change password of account");
            System.out.println("3. Room management");
            System.out.println("4. Receipt management");
            System.out.println("5. Monthly revenue statistics");
            System.out.println("6. Exit");
            System.out.println("Select a number:");
            boolean check = false;
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println(account.toString());
                        break;
                    case 2:
                        changePasswordAccount(account);
                        break;
                    case 3:
                        roomManagement.menuRoom();
                        break;
                    case 4:
                        receiptManagement.menuReceipt();
                        break;
                    case 5:
                        receiptManagement.monthlyRevenue();
                        break;
                    case 6:
                        check = true;
                        break;
                }
                if (check) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Format select");
            }
        }
    }
}
