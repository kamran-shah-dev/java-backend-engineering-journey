package Threads;

public class ThreadLifeCycle extends Thread{
    @Override
    public void run() {
        System.out.println("Thread Is Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ThreadLifeCycle t1 = new ThreadLifeCycle();
        System.out.println(t1.getState());
        t1.start(); // Makes thread runnable, that means it is ready to run or running
        System.out.println(t1.getState());
        Thread.sleep(100);
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
    }
}
