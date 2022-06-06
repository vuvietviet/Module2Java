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
        while (true) {
            System.out.println("------Menu Receipt-----");
            System.out.println("1. Add receipt");
            System.out.println("2. Edit information of receipt");
            System.out.println("3. Search receipt");
            System.out.println("4. Show list of receipt");
            System.out.println("5. Paid and return the room");
            System.out.println("6. Exit");
            System.out.println("Select a number: ");
            boolean check = false;
            try {
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
                    case 5:
                        resetStatus();
                        break;
                    case 6:
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

    public Receipt createReceipt() {
        String nameRoom = receiptValidate.validateNameRoom(roomList);
        int priceRoom = roomValidate.validatePriceRoom();
        String idReceipt = receiptValidate.validateIdReceipt(receiptList);
        Date startTime = receiptValidate.validateDate("start time");
        Date endTime = receiptValidate.validateDate("end time");
        String rentalStaffName = receiptValidate.validateString("rental staff name");
        String customerName = receiptValidate.validateString("customer name");
        String statusReceipt = receiptValidate.validateStatusReceipt();
        changeStatusRoom(nameRoom,"Room with people");
        return new Receipt(nameRoom,priceRoom,idReceipt,startTime,endTime,rentalStaffName,customerName,statusReceipt);
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
        for (Receipt receipt: receiptList) {
            System.out.println(receipt);
        }
    }

    public void monthlyRevenue(){
        List<Integer> totalPayableList = new ArrayList<>();
        long totalMonthlyRevenue = 0;
        int month = receiptValidate.validateMonth();
        int year = receiptValidate.validateYear();
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getEndTime().getMonth() == month &&
                    receiptList.get(i).getEndTime().getYear() == year &&
            receiptList.get(i).getStatusReceipt().equals("Paid")) {
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
}
