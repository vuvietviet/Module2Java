import java.util.Stack;

public class DecimalToBinaryExample {
    public void convertBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            int d = num % 2;
            stack.push(d);
            num /= 2;
        }

        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        int decimalNumber = 111;
        System.out.print("Binary of " + decimalNumber + " is: ");
        new DecimalToBinaryExample().convertBinary(decimalNumber);
    }
}
