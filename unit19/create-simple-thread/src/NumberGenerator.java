public class NumberGenerator implements Runnable{
    private final String nameThread;

    public NumberGenerator(String name) {
        this.nameThread = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread: " + nameThread + " - " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("my thread " + nameThread + " interrupted");
        }
    }
}
