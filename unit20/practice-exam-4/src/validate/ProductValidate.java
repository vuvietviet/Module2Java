package validate;

import models.Products;
import org.omg.IOP.CodecPackage.FormatMismatch;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductValidate {
    Scanner scanner = new Scanner(System.in);
    public int getIndexId(String id, List<Products> productsList) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public String validateId(List<Products> productsList) {
        while (true) {
            try {
                System.out.println("Nhập mã:");
                String id = scanner.nextLine();
                if (getIndexId(id, productsList) != -1) {
                    throw new Exception();
                }
                Pattern pattern = Pattern.compile("[0-9a-zA-Z]+");
                Matcher matcher = pattern.matcher(id);
                if (matcher.matches()) {
                    return id;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Lỗi định dạng mã");
            } catch (Exception e) {
                System.err.println("Lỗi trùng mã");
            }
        }
    }

    public String validateString(String string) {
        while (true) {
            try {
                System.out.println("Nhập " + string + " : ");
                String inputString = scanner.nextLine();

                Pattern pattern = Pattern.compile(".+");
                Matcher matcher = pattern.matcher(inputString);
                if (matcher.matches()) {
                    return inputString;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Lỗi định dạng " + string);
            }
        }
    }

    public double validatePrice() {
        while (true) {
            try {
                System.out.println("Nhập giá: ");
                String price = scanner.nextLine();

                Pattern pattern = Pattern.compile("[0-9]+\\.?[0-9]{0,2}");
                Matcher matcher = pattern.matcher(price);
                if (matcher.matches()) {
                    return Double.parseDouble(price);
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Lỗi định dạng giá" );
            }
        }
    }

    public int validateAmount() {
        while (true) {
            try {
                System.out.println("Nhập số lượng: ");
                String amount = scanner.nextLine();

                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(amount);
                if (matcher.matches()) {
                    return Integer.parseInt(amount);
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Lỗi định dạng số lượng" );
            }
        }
    }
}
