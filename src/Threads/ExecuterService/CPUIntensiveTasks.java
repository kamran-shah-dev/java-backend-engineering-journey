package Threads.ExecuterService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// this will be a program to show how to finalize your thread pool size
public class CPUIntensiveTasks {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(cores);

        for (int i = 0; i < cores+1; i++) {
            service.execute(new CPUTask());
        }
    }
}

class CPUTask implements Runnable {
    @Override
    public void run() {
        System.out.println("CPU Task is being executed by: " + Thread.currentThread().getName());
    }
}
