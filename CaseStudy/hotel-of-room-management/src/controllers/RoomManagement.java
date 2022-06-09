package controllers;

import io.ReaderAndWriterRoom;
import models.Room;
import sort.ReceiptSort;
import sort.RoomSort;
import validate.ReceiptValidate;
import validate.RoomValidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManagement {
    Scanner scanner = new Scanner(System.in);
    RoomValidate roomValidate = new RoomValidate();
    ReceiptValidate receiptValidate = new ReceiptValidate();
    ReaderAndWriterRoom readerAndWriterRoom = new ReaderAndWriterRoom();
    List<Room> roomList = readerAndWriterRoom.readFile();
    public void menuRoom() {
        while (true) {
            System.out.println("\n------Menu Room-----");
            System.out.println("1. Add room");
            System.out.println("2. Edit information of room");
            System.out.println("3. Delete room");
            System.out.println("4. Search empty room by price");
            System.out.println("5. Show list of room");
            System.out.println("6. Sort room to floor");
            System.out.println("7. Exit");
            System.out.println("Select a number:");
            boolean check = false;
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addRoom();
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
                    case 5:
                        showList();
                        break;
                    case 6:
                        sortRoom();
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

    public Room createRoom() {
        String nameRoom = roomValidate.validateNameRoom(roomList);
        int priceRoom = roomValidate.validatePriceRoom();
        String statusRoom = roomValidate.validateStatusRoom();
        int toiletNumber = roomValidate.validateNumberOf("toilet number");
        int bedroomNumber = roomValidate.validateNumberOf("bedroom number");
        return new Room(nameRoom,priceRoom,statusRoom,toiletNumber,bedroomNumber);
    }

    public Room createRoomToEdit() {
        String nameRoom = receiptValidate.validateNameRoomDuplicate(roomList);
        int priceRoom = roomValidate.validatePriceRoom();
        String statusRoom = roomValidate.validateStatusRoom();
        int toiletNumber = roomValidate.validateNumberOf("toilet number");
        int bedroomNumber = roomValidate.validateNumberOf("bedroom number");
        return new Room(nameRoom,priceRoom,statusRoom,toiletNumber,bedroomNumber);
    }

    public void addRoom() {
        roomList.add(createRoom());
        readerAndWriterRoom.writeFile(roomList);
        System.out.println("Add room success");
    }

    public void editRoom() {
        System.out.println("Input name room to edit:");
        String nameRoom = scanner.nextLine();
        String display = "Not found name room to edit";
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getNameRoom().equals(nameRoom)) {
                roomList.set(i,createRoomToEdit());
                readerAndWriterRoom.writeFile(roomList);
                display = "Edit success";
            }
        }
        System.out.println(display);
    }

    public void deleteRoom() {
        System.out.println("Input name room to delete:");
        String nameRoom = scanner.nextLine();
        String display = "Not found name room to delete";
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getNameRoom().equals(nameRoom)) {
                roomList.remove(i);
                readerAndWriterRoom.writeFile(roomList);
                display = "Delete success";
            }
        }
        System.out.println(display);
    }

    public void searchRoomByPrice() {
        List<Room> newRoomList = new ArrayList<>();
        System.out.println("Input min price:");
        int priceMin = Integer.parseInt(scanner.nextLine());
        System.out.println("Input max price:");
        int priceMax = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getPriceRoom() >= priceMin &&
                    roomList.get(i).getPriceRoom() <= priceMax &&
                    roomList.get(i).getStatusRoom().equals("Room is empty")) {
                newRoomList.add(roomList.get(i));
            }
        }

        try {
            for (Room room: newRoomList) {
                System.out.println(room);
            }
        } catch (Exception e) {
            System.err.println("Not found room to desire price");
        }
    }

    public void showList() {
        for (int i = 0; i < roomList.size(); i++) {
            if ((i+1) % 6 == 0) {
                System.out.println(roomList.get(i));
                scanner.nextLine();
            } else {
                System.out.println(roomList.get(i));
            }
        }
    }

    public void sortRoom() {
        roomList.sort(new RoomSort());
        readerAndWriterRoom.writeFile(roomList);
        System.out.println("Sort room success");
    }
}
