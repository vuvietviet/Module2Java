package controllers;

import io.ReaderAndWriterReceipt;
import io.ReaderAndWriterRoom;
import models.Receipt;
import models.Room;
import validate.ReceiptValidate;
import validate.RoomValidate;

import java.util.ArrayList;
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
    public void menuReceipt() {
        System.out.println("------Menu Receipt-----");
        System.out.println("1. Add receipt");
        System.out.println("2. Edit information of receipt");
        System.out.println("3. Search receipt");
        System.out.println("4. Show list of receipt");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                addReceipt();
                break;
            case 2:
                editReceipt();
                break;
            case 3:
                searchReceipt();
                break;
            case 4:
                showReceiptList();
                break;
        }
    }

    public Receipt createReceipt() {
        String nameRoom = receiptValidate.validateNameRoom(roomList);
        int priceRoom = roomValidate.validatePriceRoom();
        String idReceipt = receiptValidate.validateIdReceipt(receiptList);
        Date startTime = receiptValidate.validateDate("start time");
        Date endTime = receiptValidate.validateDate("end time");
        String rentalStaffName = receiptValidate.validateString("rental staff name");
        String customerName = receiptValidate.validateString("customer name");
        resetStatusRoom(nameRoom);
        return new Receipt(nameRoom,priceRoom,idReceipt,startTime,endTime,rentalStaffName,customerName);
    }

    public void addReceipt() {
        receiptList.add(createReceipt());
        readerAndWriterReceipt.writeFile(receiptList);
        System.out.println("Add receipt success");
    }

    public void editReceipt() {
        System.out.println("Input id receipt to edit:");
        String idReceipt = scanner.nextLine();
        String display = "Not found id receipt to edit";
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getIdReceipt().equals(idReceipt)) {
                receiptList.set(i,createReceipt());
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
        for (Receipt receipt: receiptList) {
            System.out.println(receipt);
        }
    }

    public void monthlyRevenue(){
        List<Integer> totalPayableList = new ArrayList<Integer>();
        long totalMonthlyRevenue = 0;
        System.out.println("Input month to calculate revenue:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Input year have month to calculate revenue:");
        int year = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getEndTime().getMonth() == month &&
                    receiptList.get(i).getEndTime().getYear() == year) {
                totalPayableList.add(receiptList.get(i).calculateTotalPayable());
            }
        }

        try {
            for (Integer number: totalPayableList) {
                totalMonthlyRevenue += number;
            }
        } catch (Exception e) {
            System.out.println("Total revenue of month " + month + " year " + year + " = " + totalMonthlyRevenue);
        }

        System.out.println("Total revenue of month " + month + " year " + year + " = " + totalMonthlyRevenue);
    }

    public void resetStatusRoom(String nameRoom) {
        String display = "Not found name room to reset status";
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getNameRoom().equals(nameRoom)) {
                roomList.get(i).setStatusRoom("Room with people");
                readerAndWriterRoom.writeFile(roomList);
                display = "Reset status success";
            }
        }
        System.out.println(display);
    }
}
