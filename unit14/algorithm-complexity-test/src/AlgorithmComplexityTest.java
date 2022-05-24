import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        int[] frequentChar = new int[255];                                  //{1}
        for (int i = 0; i < inputString.length(); i++) {                    //{2}
            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
            int ascii = (int) inputString.charAt(i);                        //{3}
            /* Tăng giá trị tần suất */
            frequentChar[ascii] += 1;                                       //{4}
        }

        int max = 0;                                                        //{5}
        char character = (char) 255; /* empty character */                  //{6}
        for (int j = 0; j < 255; j++) {                                     //{7}
            if (frequentChar[j] > max) {                                    //{8}
                max = frequentChar[j];                                      //{9}
                character = (char) j;                                       //{10}
            }
        }
        System.out.println("The most appearing letter is '" +
                character + "' with a frequency of " + max + " times");
    }
}

/* Độ phức tạp của thuật toán là:
* Lệnh gán => T{1} = T{3} = T{4} = O(1);
* Vòng lặp {2} thực hiện (n) lần, mỗi lần O(1) do đó vòng lặp {2}
*   tốn O((n).1) = O(n)  với  n là độ dài chuỗi ký tự.
*   => T{2} = O(n);
*
* Lệnh gán => T{5} = T{6} = T{9} = T{10} = O(1);
* Lệnh so sánh => T{8} = O(1);
* Vòng lặp {7} thực hiện (255) lần, mỗi lần O(1) do đó vòng lặp {7}
*   tốn O((255).1) = O(255).
*   => T{7} = O(255);
*
* Ta sẽ có 2 trường hợp
TH1: n <= 255
Khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh {7}
* và bằng O(255)

TH2: n> 255
Khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh {2}
* và bằng O(n)
* */
