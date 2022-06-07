package sort;

import models.Room;

import java.util.Comparator;

public class RoomSort implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        int valueO1 = Integer.parseInt(o1.getNameRoom());
        int valueO2 = Integer.parseInt(o2.getNameRoom());
        if (valueO1 > valueO2) {
            return 1;
        }
        return -1;
    }
}
