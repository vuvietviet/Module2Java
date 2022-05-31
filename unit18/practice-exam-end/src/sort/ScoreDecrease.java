package sort;

import models.Students;

import java.util.Comparator;

public class ScoreDecrease implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return (int) (o2.getScoreMedium() - o1.getScoreMedium());
    }
}
