import java.util.Scanner;

public class InsertSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " value:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }

        System.out.println("\nBegin sort processing...");
        insertSortByStep(list);

        System.out.print("List sorted: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
    }

    public static void insertSortByStep(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int x = list[i];
            int pos = i;
            while (pos > 0 && x < list[pos - 1]) {
                System.out.println("Assign " + list[pos] + " is " + list[pos - 1]);
                list[pos] = list[pos - 1];
                pos--;
            }
            System.out.println("Assign " + list[pos] + " is " + x);
            list[pos] = x;

            System.out.print("List after the  " + i + "' sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }
}
