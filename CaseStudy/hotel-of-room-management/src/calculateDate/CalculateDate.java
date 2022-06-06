package calculateDate;

import java.util.Date;

public class CalculateDate {
    public boolean checkYear(int year) {
        boolean isLeapYear = false;

        boolean isDivisibleBy4 = year % 4 == 0;
        if(isDivisibleBy4){
            boolean isDivisibleBy100 = year % 100 == 0;
            if(isDivisibleBy100){
                boolean isDivisibleBy400 = year % 400 == 0;
                if(isDivisibleBy400){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        return isLeapYear;
    }

    public int calculateTotalDate(Date startTime, Date endTime) {
        int totalDate = 0;
        if (startTime.getMonth() == endTime.getMonth() &&
        startTime.getYear() == endTime.getYear()) {
            totalDate = endTime.getDate() - startTime.getDate();
        } else {
            switch (startTime.getMonth()) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    totalDate = 31 - startTime.getDate() + endTime.getDate();
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    totalDate = 30 - startTime.getDate() + endTime.getDate();
                    break;
                case 2:
                    if (checkYear(startTime.getYear())) {
                        totalDate = 29 - startTime.getDate() + endTime.getDate();
                    } else {
                        totalDate = 28 - startTime.getDate() + endTime.getDate();
                    }
                    break;
            }
        }
        return totalDate;
    }
}
