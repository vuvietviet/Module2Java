import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void checkFizzBuzz() {
        int num = 15;
        String exprcted = "FizzBuzz, number is: mot nam";

        String result = FizzBuzz.check(num);
        assertEquals(exprcted, result);
    }

    @Test
    void checkFizz() {
        int num = 9;
        String exprcted = "Fizz, number is: chin";

        String result = FizzBuzz.check(num);
        assertEquals(exprcted, result);
    }

    @Test
    void checkBuzz() {
        int num = 10;
        String exprcted = "Buzz, number is: mot khong";

        String result = FizzBuzz.check(num);
        assertEquals(exprcted, result);
    }

    @Test
    void checkNotFizzBuzz() {
        int num = 14;
        String exprcted = "14";

        String result = FizzBuzz.check(num);
        assertEquals(exprcted, result);
    }

    @Test
    void checkFizzContains3() {
        int num = 23;
        String exprcted = "Fizz, number is: hai ba";

        String result = FizzBuzz.check(num);
        assertEquals(exprcted, result);
    }

    @Test
    void checkBuzzContains5() {
        int num = 52;
        String exprcted = "Buzz, number is: nam hai";

        String result = FizzBuzz.check(num);
        assertEquals(exprcted, result);
    }
}