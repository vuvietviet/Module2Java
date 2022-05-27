import java.util.Scanner;

public class IllegalTriangleExceptionExample {
    public void checkTriangle(int a,int b,int c) throws IllegalTriangleException{
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("The triangle is not compatible!");
        } else {
            System.out.println("The triangle is compatible!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IllegalTriangleExceptionExample e = new IllegalTriangleExceptionExample();

        try {
            System.out.println("Enter a,b,c is side of triangle");
                int a = sc.nextInt();
                System.out.println("a = " + a);
                int b = sc.nextInt();
                System.out.println("b = " + b);
                int c = sc.nextInt();
                System.out.println("c = " + c);

            try {
                e.checkTriangle(a,b,c);
            } catch (IllegalTriangleException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception e1) {
            System.out.println("Format error!");
        }
    }
}


