package Threads.Multithread;
// Not a recommendable approach, instead use synchronized keyword at method level, but only if the method is too small
// and the whole method is working on shared resources.
public class CustomLock {
    private static int counter1, counter2;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread incOne = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                incrementCounterOne();
        });

        Thread incTwo = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                incrementCounterTwo();
        });

        incOne.start();
        incTwo.start();

        try {
            incOne.join();
            incTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Result: \n" + "Counter 1 = " + counter1 + " , Counter 2 = " + counter2);

    }

    public static void incrementCounterOne () {
        synchronized (lock1) {
            counter1++;
        }

    }

    public static synchronized void incrementCounterTwo () {
        synchronized (lock2) {
            counter2++;
        }
    }
}
