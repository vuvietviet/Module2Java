public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberGenerator("Thread1"));
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        Thread thread2 = new Thread(new NumberGenerator("Thread2"));
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();

    }
}
