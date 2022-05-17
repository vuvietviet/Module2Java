import java.util.Scanner;

public class ManagerNhanvien {
    NhanVien[] nhanViens = new NhanVien[0];
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("Menu");
        System.out.println("1. Add Nhân Viên");
        System.out.println("2. Edit Nhân Viên");
        System.out.println("3. Delete Nhân Viên");
        System.out.println("4. Tính Lương");
        System.out.println("5. Show");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                showCreateNV();
                break;
            case 2:
                editNV();
                break;
            case 3:
                deleteNV();
                break;
            case 4:
                showTinhLuong();
                break;
            case 5:
                for (NhanVien nv : nhanViens) {
                    System.out.println(nv);
                }
        }
    }

    public NhanVien createNhanVien(boolean isFullTime) {
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        if (isFullTime) {
            System.out.println("Nhập hệ số");
            int heSo = Integer.parseInt(scanner.nextLine());
            return new FullTime(id, name, age, heSo);
        } else {
            System.out.println("Nhập số buổi");
            int numberTime = Integer.parseInt(scanner.nextLine());
            return new PartTime(id, name, age, numberTime);
        }
    }

    public void showCreateNV() {
        System.out.println("1. Tạo FullTime");
        System.out.println("2. Tạo PartTime");
        int choice1 = Integer.parseInt(scanner.nextLine());
        switch (choice1) {
            case 1:
                NhanVien nhanVienFull = createNhanVien(true);
                add(nhanVienFull);
                break;
            case 2:
                NhanVien nhanVienPart = createNhanVien(false);
                add(nhanVienPart);
                break;
        }
    }

    public void add(NhanVien nhanVien) {
        NhanVien[] newNV = new NhanVien[nhanViens.length + 1];

        for (int i = 0; i < nhanViens.length; i++) {
            newNV[i] = nhanViens[i];
        }
        newNV[newNV.length - 1] = nhanVien;
        nhanViens = newNV;
    }

    public void editNV() {
        System.out.println("Nhập id nhân viên muốn sửa :");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nhanViens.length; i++) {
            if (nhanViens[i].getId() == id) {
                nhanViens[i] = createNhanVien(nhanViens[i] instanceof FullTime);
            }
        }
    }

    public void showTinhLuong() {
        System.out.println("1. FullTime");
        System.out.println("2. PartTime");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                for (NhanVien nv : nhanViens) {
                    if (nv instanceof FullTime) {
                        System.out.println(nv.getName() + " = " + nv.tinhLuong());
                    }
                }
                break;
            case 2:
                for (NhanVien nv : nhanViens) {
                    if (nv instanceof PartTime) {
                        System.out.println(nv.getName() + " = " + nv.tinhLuong());
                    }
                }
                break;
        }
    }

    public void deleteNV() {
        NhanVien[] newNV = new NhanVien[nhanViens.length - 1];
        System.out.println("Nhập id muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < nhanViens.length; i++) {
            if (nhanViens[i].getId() == id) {
                index = i;
            }
        }
        if (index != -1) {
            for (int i = 0; i < newNV.length; i++) {
                if (i < index) {
                    newNV[i] = nhanViens[i];
                } else {
                    newNV[i] = nhanViens[i + 1];
                }
            }
        }
        nhanViens = newNV;
    }
}
