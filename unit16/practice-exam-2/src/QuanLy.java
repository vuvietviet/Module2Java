import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class QuanLy {
    ArrayList<TheMuon> arr = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("Menu");
        System.out.println("1. Thêm người mượn");
        System.out.println("2. Danh sách người mượn");
        System.out.println("3. Sách mượn cần trả vào cuối tháng");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                show();
                break;
            case 3:
                checkDate();
                break;
        }
    }

    public TheMuon create() throws ParseException {
        System.out.println("Nhập họ tên:");
        String hoTen = sc.nextLine();
        System.out.println("Nhập MSV:");
        String MSV = sc.nextLine();
        System.out.println("Nhập ngày sinh:");
        Date ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        System.out.println("Nhập lớp:");
        String lop = sc.nextLine();
        System.out.println("Nhập số phiếu mượn:");
        int soPhieuMuon = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập ngày mượn:");
        Date ngayMuon = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        System.out.println("Nhập hạn trả:");
        Date hanTra = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());;
        System.out.println("Nhập số hiệu sách:");
        String soHieuSach = sc.nextLine();

        return new TheMuon(hoTen,MSV,ngaySinh,lop,soPhieuMuon,ngayMuon,hanTra,soHieuSach);
    }

    public void add() {
        boolean check = false;
        while (!check) {
            try {
                arr.add(create());
                check = true;
            } catch (ParseException e) {
                System.err.println("Format date error! Enter dd/MM/yyyy");
            }
        }

    }

    public void show() {
        for (TheMuon ele: arr) {
            System.out.println(ele);
        }
    }

    public void checkDate() {
        ArrayList<TheMuon> arrCanTra = new ArrayList<>();
        Date now = new Date();
        int dateNowMonth = 0;
        switch (now.getMonth() + 1) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dateNowMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dateNowMonth = 30;
                break;
            case 2:
                int year = now.getYear() + 1900;
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

                if (isLeapYear) {
                    dateNowMonth = 29;
                } else {
                    dateNowMonth = 28;
                }

        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getHanTra().getDate() == dateNowMonth) {
                arrCanTra.add(arr.get(i));
            }
        }

        for (TheMuon ele: arrCanTra) {
            System.out.println(ele);
        }
    }
}
