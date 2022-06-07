package sort;

import models.Receipt;

import java.util.Comparator;

public class ReceiptSort implements Comparator<Receipt> {

    @Override
    public int compare(Receipt o1, Receipt o2) {
        if (o1.getStartTime().getYear() == o2.getStartTime().getYear()) {
            if (o1.getStartTime().getMonth() == o2.getStartTime().getMonth()) {
                if (o1.getStartTime().getDate() < o2.getStartTime().getDate()) {
                    return 1;
                }
                return -1;
            } else {
                if (o1.getStartTime().getMonth() < o2.getStartTime().getMonth()) {
                    return 1;
                }
                return -1;
            }
        } else {
            if (o1.getStartTime().getYear() < o2.getStartTime().getYear()) {
                return 1;
            }
            return -1;
        }
    }
}
