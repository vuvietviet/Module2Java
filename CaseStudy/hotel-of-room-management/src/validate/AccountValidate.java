package validate;

import models.Account;
import org.omg.IOP.CodecPackage.FormatMismatch;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountValidate {
    Scanner scanner = new Scanner(System.in);
    public int getIndexAccountName(String accountName, List<Account> accountList) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountName().equals(accountName)) {
                return i;
            }
        }
        return -1;
    }

    public String validateAccountName(List<Account> accountList) {
        while (true) {
            try {
                System.out.println("Input account name:");
                String accountName = scanner.nextLine();
                if (getIndexAccountName(accountName, accountList) != -1) {
                    throw new Exception();
                }
                Pattern pattern = Pattern.compile(".{8,16}");
                Matcher matcher = pattern.matcher(accountName);
                if (matcher.matches()) {
                    return accountName;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format account name");
            } catch (Exception e) {
                System.err.println("Duplicate account name");
            }
        }
    }

    public String validatePassWord() {
        while (true) {
            try {
                System.out.println("Input password: ");
                String passWord = scanner.nextLine();

                Pattern pattern = Pattern.compile(".{8,16}");
                Matcher matcher = pattern.matcher(passWord);
                if (matcher.matches()) {
                    return passWord;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format password" );
            }
        }
    }

    public String validateNumberPhone() {
        while (true) {
            try {
                System.out.println("Input number phone: ");
                String numberPhone = scanner.nextLine();

                Pattern pattern = Pattern.compile("^0[0-9]{9}$");
                Matcher matcher = pattern.matcher(numberPhone);
                if (matcher.matches()) {
                    return numberPhone;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format number phone" );
            }
        }
    }

    public String validateString(String string) {
        while (true) {
            try {
                System.out.println("Input " + string + ": ");
                String inputString = scanner.nextLine();

                Pattern pattern = Pattern.compile("[a-zA-Z0-9-_\\s]+");
                Matcher matcher = pattern.matcher(inputString);
                if (matcher.matches()) {
                    return inputString;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format " + string);
            }
        }
    }

    public String validateEmail() {
        while (true) {
            try {
                System.out.println("Input email: ");
                String email = scanner.nextLine();

                Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    return email;
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format email" );
            }
        }
    }

    public int validateAge() {
        while (true) {
            try {
                System.out.println("Input age: ");
                String age = scanner.nextLine();

                Pattern pattern = Pattern.compile("19|(^[2-9][0-9])");
                Matcher matcher = pattern.matcher(age);
                if (matcher.matches()) {
                    return Integer.parseInt(age);
                } else {
                    throw new FormatMismatch();
                }
            } catch (FormatMismatch f) {
                System.err.println("Format age" );
            }
        }
    }

}
