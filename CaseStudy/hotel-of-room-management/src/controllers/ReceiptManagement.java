package controllers;

import io.ReaderAndWriterReceipt;
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
    List<Receipt> receiptList = readerAndWriterReceipt.readFile();
    List<Room> roomList = readerAndWriterReceipt.readFileRoom();
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
                editRoom();
                break;
            case 3:
                deleteRoom();
                break;
            case 4:
                searchRoomByPrice();
                break;
        }
    }

    public Receipt createReceipt() {
        String nameRoom = roomValidate.validateNameRoom(roomList);
        int priceRoom = roomValidate.validatePriceRoom();
        String idReceipt = receiptValidate.validateIdReceipt(receiptList);
        Date startTime = receiptValidate.validateDate("start time");
        Date endTime = receiptValidate.validateDate("end time");
        String rentalStaffName = receiptValidate.validateString("rental staff name");
        String customerName = receiptValidate.validateString("customer name");
        return new Receipt(nameRoom,priceRoom,idReceipt,startTime,endTime,rentalStaffName,customerName);
    }

    public void addReceipt() {
        receiptList.add(createReceipt());
        readerAndWriterReceipt.writeFile(receiptList);
        System.out.println("Add receipt success");
    }
}
