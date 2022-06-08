package controllers;

import io.ReaderAndWriter;
import models.Products;
import sort.PriceDecrease;
import sort.PriceIncrease;
import validate.ProductValidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    ProductValidate productValidate = new ProductValidate();
    ReaderAndWriter readerAndWriter = new ReaderAndWriter();
    List<Products> productsList = new ArrayList<>();
    public void menu() {
        while (true) {
            System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách ");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhật ");
            System.out.println("4. Xóa ");
            System.out.println("5. Sắp xếp ");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file ");
            System.out.println("8. Ghi từ file");
            System.out.println("9. Thoát ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        show();
                        break;
                    case 2:
                        add();
                        break;
                    case 3:
                        edit();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        sort();
                        break;
                    case 6:
                        searchMaxPrice();
                        break;
                    case 7:
                        productsList = readerAndWriter.readFile();
                        break;
                    case 8:
                        readerAndWriter.writeFile(productsList);
                        break;
                    case 9:
                        System.exit(0);
                }
                break;
            } catch (Exception e) {
                System.err.println("Chọn chức năng chỉ từ 1 đến 9");
            }
        }
    }

    public void show() {
        for (int i = 0; i < productsList.size(); i++) {
            if ((i+1) % 5 == 0) {
                System.out.println(productsList.get(i));
                scanner.nextLine();
            } else {
                System.out.println(productsList.get(i));
            }
        }
    }

    public Products create() {
        String id = productValidate.validateId(productsList);
        String name = productValidate.validateString("tên sản phẩm");
        double price = productValidate.validatePrice();
        int amount = productValidate.validateAmount();
        String detail = productValidate.validateString("mô tả");
        return new Products(id,name,price,amount,detail);
    }

    public void add() {
        productsList.add(create());
        System.out.println("Thêm vào thành công");
    }

    public void edit() {
        System.out.println("Nhập mã của sản phẩm cần sửa:");
        String id = scanner.nextLine();
        String display = "Không tìm thấy mã cần sửa";
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId().equals(id)) {
                productsList.set(i,create());
                display = "Sửa thành công";
            }
        }
        System.out.println(display);
    }

    public void delete() {
        System.out.println("Nhập mã của sản phẩm cần xóa:");
        String id = scanner.nextLine();
        for (int i = 0; i < productsList.size(); i++) {
            if(productsList.get(i).getId().equals(id)) {
                System.out.println("Nhấn 'Y' để xóa");
                System.out.println("Nhấn phím còn lại để hủy");
                String check = scanner.nextLine();
                if (check.equals("Y")) {
                    productsList.remove(i);
                    break;
                } else {
                    break;
                }
            } else if (i == productsList.size() - 1){
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
                delete();
            } else if (id.equals("")) {
                break;
            }
        }
    }

    public void sort() {
        while (true) {
            System.out.println("-----Sắp xếp sản phẩm theo giá----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Sắp xếp giá tăng dần");
            System.out.println("2. Sắp xếp giá giảm dần");
            System.out.println("3. Thoát");
            System.out.println("Chọn chức năng: ");
            try {
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                    case 1:
                        productsList.sort(new PriceIncrease());
                        for (Products product: productsList) {
                            System.out.println(product);
                        }
                        break;
                    case 2:
                        productsList.sort(new PriceDecrease());
                        for (Products product: productsList) {
                            System.out.println(product);
                        }
                        break;
                    case 3:
                        break;
                }
                break;
            } catch (Exception e) {
                System.err.println("Chọn lại từ 1-3");
            }

        }
    }

    public void searchMaxPrice() {
        double maxPrice = productsList.get(0).getPrice();
        Products product = productsList.get(0);
        for (int i = 1; i < productsList.size(); i++) {
            if (maxPrice < productsList.get(i).getPrice()) {
                maxPrice = productsList.get(i).getPrice();
                product = productsList.get(i);
            }
        }
        System.out.println(product);
    }
}
