package Threads;

class MyThread extends Thread {
    public MyThread (String tname) {
        super(tname);
    }
    @Override
    public void run() {
        /* for (int i = 0; i < 5; i++) {
            int a = 5;
            for (int j = 0; j < 100000; j++)
                a++;
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - Count: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

         */

        /*for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is running");
        }

         */

        /*for (int i = 0; i < 5; i++)
        {
            System.out.println("Thred: " + Thread.currentThread().getName() + " is running");
            Thread.yield();
        }

         */

        while (true) {
            System.out.println("Thread running!");
        }
    }
}

public class ThreadFunctionss {
    public static void main(String[] args) {
        /* MyThread t1 = new MyThread("First");
        MyThread t2 = new MyThread("Second");
        MyThread t3 = new MyThread("Third");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();

         */
        /*MyThread t1 = new MyThread("Alpha");
        t1.start();
        t1.interrupt();

         */

        /* MyThread t1 = new MyThread("alpha");
        MyThread t2 = new MyThread("Beta");
        t1.start();
        t2.start();

         */

        MyThread t1 = new MyThread("Alpha");
        t1.setDaemon(true); // if we don't set it daemon,the thread is a user thread and jvm wait for it to finish, but
        // the loop is infinite so it will run infinite, now we set it daemon, it bacame a daemon (background) thread from
        // user thread, now jvm will not wait for it and it will finish regardless of loop being infinite.
        t1.start();
        System.out.println("Main thread finished...");

    }
}
