package Threads.Multithread;

public class MyThread extends Thread {
    private Counter couunter;

    public MyThread(Counter counter)
    {
        this.couunter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            couunter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2  = new MyThread(counter);

        t1.start(); t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCount());
    }
}

class Counter {
    private long count;

    public void increment() {
        count++;
    }

    public long getCount() {
        return this.count;
    }

}
