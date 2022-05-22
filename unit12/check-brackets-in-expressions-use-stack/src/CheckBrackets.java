import java.util.Stack;

public class CheckBrackets {
    public static boolean test(String inputOperation) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inputOperation.length(); i++) {
            if (inputOperation.charAt(i) == '(') {
                stack.push(inputOperation.charAt(i));
            } else if (inputOperation.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        System.out.println("Use brackets is: " + test(str));
    }
}
