import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        FileEmployees fileEmployees = new FileEmployees();
        fileEmployees.add("nam","1-1-2021");
        fileEmployees.add("nu","2-1-2022");
        fileEmployees.add("nu","1-4-2022");
        fileEmployees.add("nam","1-10-2022");
        fileEmployees.add("nu","15-1-2022");
        fileEmployees.show();

        System.out.println("-------------------------");

        fileEmployees.sortGender();
        fileEmployees.show();
    }
}
