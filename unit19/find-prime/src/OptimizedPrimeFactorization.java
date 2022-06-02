public class OptimizedPrimeFactorization extends Thread implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i < 10; i++) {
            if (i == 2 || i == 3 || i == 5) {
                System.out.println("Op - " + i);
            } else {
                for (int j = 2; j < i / 2; j++) {
                    if (i % j == 0) {
                        break;
                    } else if (j == (i / 2) - 1) {
                        System.out.println("Op - " + i);
                    }
                }
            }
        }
    }
}
