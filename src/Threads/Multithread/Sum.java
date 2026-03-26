package Threads.Multithread;

public class Sum extends Thread {
    @Override
    public void run() {
        long sum = 0;
        for (int i = 0; i < 1000000000; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
