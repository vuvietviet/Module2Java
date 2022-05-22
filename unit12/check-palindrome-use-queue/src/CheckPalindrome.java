import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.print("Enter the string to be checked: ");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        Queue queue = new LinkedList();
        for (int i = inputString.length() - 1; i >= 0 ; i--) {
            queue.add(inputString.charAt(i));
        }
        String reverseString = "";
        while (!queue.isEmpty()) {
            reverseString = reverseString + queue.remove();
        }
        if (inputString.equals(reverseString)) {
            System.out.println("This is Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
