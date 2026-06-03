package Threads.ExecuterService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CashedThreadPool {

    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 50; i++)
                executor.execute(new Task(i));
        }
    }
}
class job implements Runnable {

    private int taskId;

    public job(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is executed by - " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
