package Threads.ExecuterService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadExecutor {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new notify(), 1, 3, TimeUnit.SECONDS);
        try
        {
            if(!executor.awaitTermination(15, TimeUnit.SECONDS))
                executor.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class notify implements Runnable {

    @Override
    public void run() {
        System.out.println("System is notifying you to wake up ..........");
    }
}
