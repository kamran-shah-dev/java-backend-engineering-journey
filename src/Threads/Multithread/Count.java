package Threads.Multithread;

public class Count implements Runnable {
    @Override
    public void run() {
        long countOdd = 0;
        for (int i = 0; i < 1000000000; i++) {
            if(i % 2 == 0)
                countOdd++;
        }
        System.out.println(countOdd);
    }
}
