public class NextDayCalculator {
    public  static String nextDay(int day, int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 0 && day < 31) {
                    day += 1;
                } else if (day == 31 && month < 12) {
                    day = 1;
                    month += 1;
                } else if (day == 31 && month == 12) {
                    day = 1;
                    month = 1;
                    year += 1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 0 && day < 30) {
                    day += 1;
                } else if (day == 30) {
                    day = 1;
                    month += 1;
                }
                break;
            case 2:
                if (isFebruaryhas29days(year)) {
                    if (day > 0 && day < 29) {
                        day += 1;
                    } else if (day == 29) {
                        day = 1;
                        month += 1;
                    }
                } else {
                    if (day > 0 && day < 28) {
                        day += 1;
                    } else if (day == 28) {
                        day = 1;
                        month += 1;
                    }
                }
        }
        return day + "/" + month + "/" + year;
    }

    private static boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        boolean isDivisibleBy4 = year % 4 == 0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = year % 400 == 0;
                if (isDivisibleBy400) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }

    private static boolean isFebruaryhas29days(int year) {
        boolean has29days = false;
        if (isLeapYear(year)) {
            has29days = true;
        }
        return has29days;
    }
}
