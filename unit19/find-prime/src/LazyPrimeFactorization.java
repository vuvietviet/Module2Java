public class LazyPrimeFactorization extends Thread implements Runnable{
    @Override
    public void run() {
        for (int i = 2; i < 10; i++) {
            if (i == 2 || i == 3) {
                System.out.println("Lazy - " + i);
            } else {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        break;
                    } else if (j == i - 1) {
                        System.out.println("Lazy - " + i);
                    }
                }
            }
        }
    }
}
