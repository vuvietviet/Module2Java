package validate;

import models.Account;
import models.Receipt;
import org.omg.IOP.CodecPackage.FormatMismatch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiptValidate {
    Scanner scanner = new Scanner(System.in);
    public int getIndexIdReceipt(String idReceipt, List<Receipt> receiptList) {
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getIdReceipt().equals(idReceipt)) {
                return i;
            }
        }
        return -1;
    }

    public String validateIdReceipt(List<Receipt> receiptList) {
        while (true) {
            try {
                System.out.println("Input id receipt:");
                String idReceipt = scanner.nextLine();
                if (getIndexIdReceipt(idReceipt, receiptList) != -1) {
                    throw new Exception();
                }
                Pattern pattern = Pattern.compile("[0-9]{6,7}");
                Matcher matcher = pattern.matcher(idReceipt);
                if (matcher.matches()) {
                    return idReceipt;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format id receipt");
            } catch (Exception e) {
                System.err.println("Duplicate id receipt");
            }
        }
    }

    public Date validateDate(String name) {
        while (true) {
            try {
                System.out.println("Input " + name + ": ");
                String inputDate = scanner.nextLine();

                Pattern pattern = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
                Matcher matcher = pattern.matcher(inputDate);
                if (matcher.matches()) {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
                    return date;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format " + name);
            } catch (ParseException e) {
                System.err.println("Runtime exception");;
            }
        }
    }

    public String validateString(String name) {
        while (true) {
            try {
                System.out.println("Input " + name + ": ");
                String inputString = scanner.nextLine();

                Pattern pattern = Pattern.compile("[a-zA-Z-_]+");
                Matcher matcher = pattern.matcher(inputString);
                if (matcher.matches()) {
                    return inputString;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format " + name);
            }
        }
    }
}
