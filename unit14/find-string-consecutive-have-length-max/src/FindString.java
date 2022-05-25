import java.util.LinkedList;
import java.util.Scanner;

public class FindString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Input String: ");
        String string = input.nextLine();

        for (int i = 0; i < string.length(); i++) { 		//1 Vòng lặp
            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
                list.clear(); //1 câu lệnh
            }

            list.add(string.charAt(i)); // 1 câu lệnh

            if (list.size() > max.size()) { // 1 câu lệnh
                max.clear();
                max.addAll(list);
            }
        }

        for (Character ch: max) { // 1 vòng lặp
            System.out.print(ch); // 1 câu lệnh
        }
    }
}

/* Tính độ phức tạp của thuật toán:
 * Lệnh gán => T{g} = O(1);
 * Lệnh so sánh => T{ss} = O(1);
 * Vòng lặp thứ nhất thực hiện (n) lần, mỗi lần thực hiện các câu lệnh
 *      gán và so sánh tốn O(1) do đó vòng lặp {2}
 *      tốn O((n).(1 + 1 + ... + 1) = O(n)  với  n là độ dài chuỗi ký tự.
 *      => T{v1} = O(n);
 * Vòng lặp thứ hai duyệt qua danh sách max chứa m kí tự
 *      => T{v2} = O(m);
 * Vì n > m
 * => T = T{v1} = n;
 */
