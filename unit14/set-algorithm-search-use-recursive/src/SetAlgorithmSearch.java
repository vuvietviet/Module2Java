import java.util.Arrays;
import java.util.Scanner;

public class SetAlgorithmSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" i = " + i + ",enter a number:");
            int num = Integer.parseInt(sc.nextLine());
            arr[i] = num;
        }


        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.print("\nEnter a number to search: ");
        int value = Integer.parseInt(sc.nextLine());
        String result = binarySearch(arr,0,arr.length - 1,value);
        System.out.println(result);
    }

    public static String binarySearch(int[] array, int left, int right ,int value) {
        while (left <= right) {
            int middle = (left + right) / 2;

            if (array[middle] == value) {
                return "Number " + value + " at location " + middle;
            } else if (array[middle] < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return "Not found";
    }
}
