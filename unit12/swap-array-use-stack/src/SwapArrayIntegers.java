import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class SwapArrayIntegers {
    public static void main(String[] args) {
        int[] arrInt = {1,2,3,4,5};
        Stack<Integer>  integerStack = new Stack<>();
        for (int i = 0; i < arrInt.length; i++) {
            integerStack.push(arrInt[i]);
        }

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = integerStack.pop();
        }

        for (int ele: arrInt) {
            System.out.print(ele + " ");
        }

        System.out.println("\n------------------------");

        String str = "Who am i";
        String[] arrStr = str.split(" ");
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < arrStr.length; i++) {
            stringStack.push(arrStr[i]);
        }

        for (int i = 0; i < arrStr.length; i++) {
            arrStr[i] = stringStack.pop();
        }

        System.out.println(Arrays.toString(arrStr));
    }

}
