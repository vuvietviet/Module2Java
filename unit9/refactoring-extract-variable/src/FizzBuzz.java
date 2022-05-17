public class FizzBuzz {
    public static String fizzBuzz(int number){
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if(isFizz && isBuzz)
            return "FizzBuzz";

        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return number + "";
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(FizzBuzz.fizzBuzz(6));
        System.out.println(FizzBuzz.fizzBuzz(25));
        System.out.println(FizzBuzz.fizzBuzz(60));
    }
}
