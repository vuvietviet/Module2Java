import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class KhachSan {
    ArrayList<Phong> phongArrayList = new ArrayList<Phong>();
    ArrayList<Nguoi> nguoiArrayList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void menu() throws ParseException {
        System.out.println("Menu");
        System.out.println("1.  Tạo phòng mới");
        System.out.println("2.  Tạo khách hàng mới");
        System.out.println("3.  Hiển thị các phòng (theo giá)");
        System.out.println("4.  Hiển thị khách hàng");
        System.out.println("5.  Tìm kiếm khách hàng theo tên");

        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                System.out.println("1.  Phòng thường");
                System.out.println("2.  Phòng VIP");
                int choice1 = Integer.parseInt(sc.nextLine());
                taoPhong(choice1);
                break;
            case 2:
                taoKhachHang();
                break;
            case 3:
                showPhong();
                break;
            case 4:
                System.out.println("1.  Theo id");
                System.out.println("2.  Theo năm sinh");
                int choice2 = Integer.parseInt(sc.nextLine());
                showKhachHang(choice2);
                break;
            case 5:
                System.out.println("Nhập họ và tên:");
                String name = sc.nextLine();
                search(name);
                break;
        }
    }

    public void taoPhong(int choice) {
        System.out.println("Địa chỉ phòng:");
        String soPhong = sc.nextLine();
        if (choice == 1) {
            Phong phong = new Phong("Thường", 200000, soPhong);
            phongArrayList.add(phong);
        } else if (choice == 2) {
            Phong phong = new Phong("VIP", 400000, soPhong);
            phongArrayList.add(phong);
        }
    }

    public void taoKhachHang() throws ParseException {
        System.out.println("Nhập họ tên:");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh:");
        Date ngaySinh = new SimpleDateFormat("dd/mm/yyyy").parse(sc.nextLine());
        System.out.println("Nhập số CMND:");
        double soCMND = Double.parseDouble(sc.nextLine());
        Nguoi nguoi = new Nguoi(name,ngaySinh,soCMND);
        nguoiArrayList.add(nguoi);
    }

    public void showPhong() {
        Collections.sort(phongArrayList);
        for (Phong ele: phongArrayList) {
            System.out.println(ele);
        }
    }

    public void showKhachHang( int choice) {
        if (choice == 1) {
            SortById sortById = new SortById();
            Collections.sort(nguoiArrayList, sortById);
            System.out.println("So sánh theo số CMND:");
            for (Nguoi ele: nguoiArrayList) {
                System.out.println(ele);
            }
        } else if (choice == 2) {
            SortByBirthDay sortByBirthDay = new SortByBirthDay();
            Collections.sort(nguoiArrayList, sortByBirthDay);
            System.out.println("So sánh theo năm sinh:");
            for (Nguoi ele: nguoiArrayList) {
                System.out.println(ele);
            }
        }
    }

    public void search(String name) {
        ArrayList<Nguoi> searchByName = new ArrayList<>();
        for (int i = 0; i < nguoiArrayList.size(); i++) {
            if ((nguoiArrayList.get(i).getHoTen()).equals(name)) {
                searchByName.add(nguoiArrayList.get(i));
            }
        }
        for (Nguoi ele: searchByName) {
            System.out.println(ele);
        }
    }
}
