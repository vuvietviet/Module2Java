package io;

import models.Account;
import models.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriterRoom {
    public void writeFile(List<Room> roomList) {
        File file = new File("rooms.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Room room: roomList) {
                bufferedWriter.write(room.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Write file success");
        } catch (IOException e) {
            System.err.println("File does not exist");
        }
    }

    public List<Room> readFile() {
        List<Room> newRoomList = new ArrayList<>();
        File file = new File("rooms.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arrStr = str.split(",");
                String nameRoom = arrStr[0];
                int priceRoom = Integer.parseInt(arrStr[1]);
                String statusRoom = arrStr[2];
                int toiletNumber = Integer.parseInt(arrStr[3]);
                int bedroomNumber = Integer.parseInt(arrStr[4]);
                newRoomList.add(new Room(nameRoom,priceRoom,statusRoom,toiletNumber,bedroomNumber));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("Read file success");
        } catch (IOException e) {
            System.err.println("File does not exist");
        }
        return newRoomList;
    }
}
