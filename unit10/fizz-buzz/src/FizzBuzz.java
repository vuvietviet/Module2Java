import java.lang.String;
import java.util.SplittableRandom;

public class FizzBuzz {
    public static String  check(int number) {
        String show = " ";
        if (number >= 0 && number < 100) {
            if (number % 3 == 0 && number % 5 == 0) {
                show = "FizzBuzz, number is: " + display(number);
            } else if (number % 5 == 0 || (String.valueOf(number)).contains("5")) {
                show = "Buzz, number is: " + display(number);
            } else if (number % 3 == 0 || (String.valueOf(number)).contains("3")) {
                show = "Fizz, number is: " + display(number);
            } else {
                show = String.valueOf(number);
            }
        }
        return show;
    }

    public static String display(int number) {
        String show = " ";
       if (number > 0 && number < 10) {
           show = showAlphabet(number);
       } else if (number >= 10 && number < 100) {
           int hangChuc = number / 10;
           show = showAlphabet(hangChuc);
           show += " ";
           int hangDonVi = number % 10;
           show += showAlphabet(hangDonVi);
       }
       return show;
    }

    public static String showAlphabet(int number) {
        String show = " ";
        switch (number) {
            case 0:
                show = "khong";
                break;
            case 1:
                show = "mot";
                break;
            case 2:
                show = "hai";
                break;
            case 3:
                show = "ba";
                break;
            case 4:
                show = "bon";
                break;
            case 5:
                show = "nam";
                break;
            case 6:
                show = "sau";
                break;
            case 7:
                show = "bay";
                break;
            case 8:
                show = "tam";
                break;
            case 9:
                show = "chin";
        }
        return show;
    }
}
