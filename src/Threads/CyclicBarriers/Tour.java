package Threads.CyclicBarriers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Tour {
    private static final int TOTAL_TOURISTS = 5;
    private static final int TOTAL_STAGES = 3;
    private static final CyclicBarrier barrier = new CyclicBarrier(TOTAL_TOURISTS, ()->{
        System.out.println("Tour Guide...");
    });

    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_TOURISTS; i++) {
            Thread tourist = new Thread(new Tourist(i+1));
            tourist.start();
        }
    }

    static class Tourist implements Runnable {

        private int touristID;

        public Tourist(int touristID) {
            this.touristID = touristID;
        }

        @Override
        public void run() {
            for (int i = 0; i < TOTAL_STAGES; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Tourist " + touristID + " reaches at stage " + (i+1));
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
