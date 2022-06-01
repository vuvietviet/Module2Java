import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerPro {
    ReaderAndWriter readerAndWriter = new ReaderAndWriter();
    Scanner sc = new Scanner(System.in);

    List<Product> productList = readerAndWriter.readFile();

    public void menu() {
        System.out.println("Menu");
        System.out.println("1.Add");
        System.out.println("2.Show");
        System.out.println("3.Search");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                show();
                break;
            case 3:
                searchByName();
                break;
        }
    }

    public void add() {
        System.out.println("Input code product:");
        String codePro = sc.nextLine();
        System.out.println("Input name product:");
        String namePro = sc.nextLine();
        System.out.println("Input price:");
        int price = Integer.parseInt(sc.nextLine());
        productList.add(new Product(codePro,namePro,price));
        readerAndWriter.writeFile(productList);
    }

    public void show() {
        for (Product ele: productList) {
            System.out.println(ele);
        }
    }

    public void searchByName() {
        System.out.println("Input name to search:");
        String name = sc.nextLine();
        for (int i = 0; i < readerAndWriter.readFile().size(); i++) {
            if (readerAndWriter.readFile().get(i).getNamePro().equals(name)) {
                System.out.println(readerAndWriter.readFile().get(i));
            }
        }
    }
}
