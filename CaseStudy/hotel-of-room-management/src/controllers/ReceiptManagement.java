package controllers;

import io.ReaderAndWriterReceipt;
import io.ReaderAndWriterRoom;
import models.Account;
import models.Receipt;
import models.Room;
import sort.ReceiptSort;
import validate.ReceiptValidate;
import validate.RoomValidate;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReceiptManagement {
    Scanner scanner = new Scanner(System.in);
    ReceiptValidate receiptValidate = new ReceiptValidate();
    RoomValidate roomValidate = new RoomValidate();
    ReaderAndWriterReceipt readerAndWriterReceipt = new ReaderAndWriterReceipt();
    ReaderAndWriterRoom readerAndWriterRoom = new ReaderAndWriterRoom();
    List<Receipt> receiptList = readerAndWriterReceipt.readFile();
    List<Room> roomList = readerAndWriterRoom.readFile();
    public void menuReceipt(Account account) {
        while (true) {
            System.out.println("\n/////////////////////-----MENU RECEIPT-----///////////////////////");
            System.out.println("1. Add receipt");
            System.out.println("2. Edit information of receipt");
            System.out.println("3. Search receipt");
            System.out.println("4. Show list of receipt");
            System.out.println("5. Sort from newReceipt to oldReceipt");
            System.out.println("6. Paid and return the room");
            System.out.println("7. Exit");
            System.out.println("Select a number: ");
            boolean check = false;
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addReceipt(account);
                        break;
                    case 2:
                        editReceipt(account);
                        break;
                    case 3:
                        searchReceipt();
                        break;
                    case 4:
                        showReceiptList();
                        break;
                    case 5:
                        sortReceipt();
                        break;
                    case 6:
                        resetStatus();
                        break;
                    case 7:
                        check = true;
                }
                if (check) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Format select");
            }
        }
    }

    public Receipt createReceipt(Account account) {
        String nameRoom = receiptValidate.validateNameRoomDuplicate(roomList);
        int priceRoom = roomList.get(roomValidate.getIndexNameRoom(nameRoom,roomList)).getPriceRoom();
        String idReceipt = receiptValidate.validateIdReceipt(receiptList);
        Date startTime = receiptValidate.validateDate("start time");
        Date endTime = receiptValidate.validateDate("end time");
        String rentalStaffName = account.getUseName();
        String customerName = receiptValidate.validateString("customer name");
        String statusReceipt = receiptValidate.validateStatusReceipt();
        changeStatusRoom(nameRoom,"Room with people");
        return new Receipt(nameRoom,priceRoom,idReceipt,startTime,endTime,rentalStaffName,customerName,statusReceipt);
    }

    public void addReceipt(Account account) {
        receiptList.add(createReceipt(account));
        readerAndWriterReceipt.writeFile(receiptList);
        System.out.println("Add receipt success");
    }

    public void editReceipt(Account account) {
        System.out.println("Input id receipt to edit:");
        String idReceipt = scanner.nextLine();
        String display = "Not found id receipt to edit";
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getIdReceipt().equals(idReceipt)) {
                receiptList.set(i,createReceipt(account));
                readerAndWriterReceipt.writeFile(receiptList);
                display = "Edit success";
            }
        }
        System.out.println(display);
    }

    public void searchReceipt() {
        System.out.println("Input id receipt to search:");
        String idReceipt = scanner.nextLine();
        String display = "Not found id receipt";
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getIdReceipt().equals(idReceipt)) {
                display = receiptList.get(i).toString();
            }
        }
        System.out.println(display);
    }

    public void showReceiptList() {
        for (int i = 0; i < receiptList.size(); i++) {
            if ((i+1) % 5 == 0) {
                System.out.println(receiptList.get(i));
                scanner.nextLine();
            } else {
                System.out.println(receiptList.get(i));
            }
        }

    }

    public void monthlyRevenue(){
        int totalMonthlyRevenue = 0;
        int month = receiptValidate.validateMonth();
        int year = receiptValidate.validateYear();
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getEndTime().getMonth() + 1 == month &&
                    receiptList.get(i).getEndTime().getYear() + 1900 == year &&
            receiptList.get(i).getStatusReceipt().equals("Paid")) {
                totalMonthlyRevenue += receiptList.get(i).calculateTotalPayable();
            }
        }
        System.out.println("Total revenue of month " + month + " year " + year + " = " + totalMonthlyRevenue);
    }

    public void changeStatusRoom(String nameRoom, String statusRoom) {
        String display = "Not found name room to change status";
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getNameRoom().equals(nameRoom)) {
                roomList.get(i).setStatusRoom(statusRoom);
                readerAndWriterRoom.writeFile(roomList);
                display = "Change status success";
            }
        }
        System.out.println(display);
    }

    public void resetStatus() {
        System.out.println("Input id receipt to reset status:");
        String idReceipt = scanner.nextLine();
        String display = "Not found id receipt to reset";
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getIdReceipt().equals(idReceipt)) {
                receiptList.get(i).setStatusReceipt("Paid");
                readerAndWriterReceipt.writeFile(receiptList);
                changeStatusRoom(receiptList.get(i).getNameRoom(),"Room is empty");
                display = "Reset success";
            }
        }
        System.out.println(display);
    }

    public void sortReceipt() {
        receiptList.sort(new ReceiptSort());
        readerAndWriterReceipt.writeFile(receiptList);
        System.out.println("Sort receipt success");
    }
}
