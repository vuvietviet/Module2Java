package validate;

import models.Room;
import org.omg.IOP.CodecPackage.FormatMismatch;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomValidate {
    Scanner scanner = new Scanner(System.in);

    public int getIndexNameRoom(String nameRoom, List<Room> roomList) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getNameRoom().equals(nameRoom)) {
                return i;
            }
        }
        return -1;
    }

    public String validateNameRoom(List<Room> roomList) {
        while (true) {
            try {
                System.out.println("Input name room:");
                String nameRoom = scanner.nextLine();
                if (getIndexNameRoom(nameRoom, roomList) != -1) {
                    throw new Exception();
                }
                Pattern pattern = Pattern.compile("[0-9]{4}");
                Matcher matcher = pattern.matcher(nameRoom);
                if (matcher.matches()) {
                    return nameRoom;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format name room");
            } catch (Exception e) {
                System.err.println("Duplicate name room");
            }
        }
    }

    public int validatePriceRoom() {
        while (true) {
            try {
                System.out.println("Input price room: ");
                String priceRoom = scanner.nextLine();

                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(priceRoom);
                if (matcher.matches()) {
                    return Integer.parseInt(priceRoom);
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format price room" );
            }
        }
    }

    public String validateStatusRoom() {
        while (true) {
            try {
                System.out.println("Input status room: ");
                System.out.println("1. Room with people");
                System.out.println("2. Room is empty");
                System.out.println("3. Room is repair");
                System.out.println("Select a number: ");
                String statusRoom = "";
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        statusRoom = "Room with people";
                        break;
                    case 2:
                        statusRoom = "Room is empty";
                        break;
                    case 3:
                        statusRoom = "Room is repair";
                        break;
                }
                if (!statusRoom.equals("")) {
                    return statusRoom;
                } else {
                    System.out.println(" Only select number from 1 to 3");
                }
            } catch (Exception e) {
                System.err.println("Format select" );
            }
        }
    }

    public int validateNumberOf(String name) {
        while (true) {
            try {
                System.out.println("Input " + name + ": ");
                String input = scanner.nextLine();

                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(input);
                if (matcher.matches()) {
                    return Integer.parseInt(input);
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format " + name);
            }
        }
    }
}
