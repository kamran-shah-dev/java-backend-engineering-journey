package Threads.BlockingQueueImplementation;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueImp {
    public static void main(String[] args) {
        SynchronousQueue<String> tasks = new SynchronousQueue<>();

        new Thread(() -> {
            String[] projects = {"Task-A", "Task-B", "Task-C"};

            for (String project : projects) {
                try {
                    System.out.println("[Project] being hand over to " + project);
                    tasks.put(project);
                    System.out.println("[Project] confirmed " + project + " was taken!!!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (!tasks.isEmpty()) {
                try {
                    System.out.println("[Project] taken "  + tasks.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
