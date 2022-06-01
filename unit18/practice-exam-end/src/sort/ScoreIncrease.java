package sort;

import models.Students;

import java.util.Comparator;

public class ScoreIncrease implements Comparator<Students> {

    @Override
    public int compare(Students o1, Students o2) {
        if (o1.getScoreMedium() > o2.getScoreMedium()) {
            return 1;
        }
        return -1;
    }
}
