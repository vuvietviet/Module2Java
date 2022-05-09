import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount of USD: ");
        usd = sc.nextDouble();

        double result = usd * vnd;
        System.out.print("VND: " + result);
    }
}
