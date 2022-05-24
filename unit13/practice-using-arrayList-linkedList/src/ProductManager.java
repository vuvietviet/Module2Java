import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<Product>();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("Menu");
        System.out.println("1. Add");
        System.out.println("2. Edit(ID)");
        System.out.println("3. Delete(ID)");
        System.out.println("4. Show");
        System.out.println("5. Search(NAME)");
        System.out.println("6. Sort(PRICE)");

        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                edit();
                break;
            case 3:
                delete();
                break;
            case 4:
                show();
                break;
            case 5:
                search();
                break;
            case 6:
                sort();
                break;
        }
    }

    public Product create() {
        System.out.println("Input ID:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Input NAME:");
        String name = sc.nextLine();
        System.out.println("Input price:");
        int price = Integer.parseInt(sc.nextLine());

        Product product = new Product(id,name,price);
        return product;
    }

    public void add() {
        products.add(create());
    }

    public void edit() {
        System.out.println("Input ID to edit:");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i,create());
            } else if (i == products.size() - 1) {
                System.out.println("Not found by ID");
            }
        }
    }

    public void delete() {
        System.out.println("Input ID to delete:");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            } else if (i == products.size() - 1) {
                System.out.println("Not found by ID");
            }
        }
    }

    public void show() {
        for (Product ele: products) {
            System.out.println(ele);
        }
    }

    public void search() {
        ArrayList<Product> arr = new ArrayList<>();
        System.out.println("Input NAME to search:");
        String name = sc.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if ((products.get(i).getName()).equals(name)) {
                arr.add(products.get(i));
            }
        }

        for (Product ele: arr) {
            System.out.println(ele);
        }
    }

    public void sort() {
        System.out.println("1. Price increase");
        System.out.println("2. Price decrease");
        int choice1 = Integer.parseInt(sc.nextLine());

        if(choice1 == 1) {
            SortByPriceIncrease sortByPriceIncrease = new SortByPriceIncrease();
            Collections.sort(products, sortByPriceIncrease);
        } else if (choice1 == 2) {
            SortByPriceDecrease sortByPriceDecrease = new SortByPriceDecrease();
            Collections.sort(products, sortByPriceDecrease);
        }

        for (Product ele: products) {
            System.out.println(ele);
        }
    }
}
