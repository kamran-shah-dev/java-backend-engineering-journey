package Threads.Multithread;

public class CountAndSum {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Sum thread1 = new Sum();
        Count count = new Count();
        Thread thread2 = new Thread(count);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Time taken by thread: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
