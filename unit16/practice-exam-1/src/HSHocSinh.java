import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HSHocSinh {
    ArrayList<Nguoi> arr = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void menu() {
        System.out.println("Menu");
        System.out.println("1.Add");
        System.out.println("2.Show");
        System.out.println("3.Search");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                try {
                    add();
                } catch (RuntimeException e) {
                    System.out.println("Format date dd/MM/yyyy");
                }
                break;
            case 2:
                show();
                break;
            case 3:
                search();
                break;

        }
    }

    public Nguoi create() throws ParseException {
        System.out.println("Enter fullname:");
        String fullname = sc.nextLine();
        System.out.println("Enter birthday:");
        Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        System.out.println("Enter address:");
        String address = sc.nextLine();
        System.out.println("Enter class name:");
        String classStudent = sc.nextLine();
        System.out.println("Enter course:");
        int course = Integer.parseInt(sc.nextLine());
        System.out.println("Enter semester:");
        int semester = Integer.parseInt(sc.nextLine());

        return new Nguoi(fullname,birthday,address,classStudent,course,semester);
    }

    public void add() {
        try {
            arr.add(create());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void show() {
        for (Nguoi ele: arr) {
            System.out.println(ele + " ");
        }
    }

    public void search() {
        ArrayList<Nguoi> arr1 = new ArrayList<>();
        System.out.println("1. Search to year of birth and address:");
        System.out.println("2. Search to class:");
        int choice1 = Integer.parseInt(sc.nextLine());
        switch (choice1) {
            case 1:
                System.out.println("Enter year of birth:");
                int year = Integer.parseInt(sc.nextLine());
                System.out.println("Enter address:");
                String address = sc.nextLine();
                for (int i = 0; i < arr.size(); i++) {
                    if (((arr.get(i).getBirthDay().getYear()) + 1900) == year &&
                            (arr.get(i).getAddress()).equals(address)) {
                        arr1.add(arr.get(i));
                    }
                }
                break;
            case 2:
                System.out.println("Enter class name:");
                String className = sc.nextLine();
                for (int i = 0; i < arr.size(); i++) {
                    if ((arr.get(i).getClassStudent()).equals(className)) {
                        arr1.add(arr.get(i));
                    }
                }
                break;
        }
        for (Nguoi ele: arr1) {
            System.out.println(ele + " ");
        }
    }
}
