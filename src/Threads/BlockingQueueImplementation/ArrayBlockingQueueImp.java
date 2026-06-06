package Threads.BlockingQueueImplementation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueImp {
    private static final int CAPACITY = 8;
    private static BlockingQueue<Integer> projects = new ArrayBlockingQueue<>(CAPACITY);
    public static void main(String[] args) {

        Thread manager = new Thread(() -> {
            try {
                for (int i = 0; i < 16; i++) {
                    projects.put(i);
                    System.out.println("Project added: " + i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread teamLeadOne = new Thread(() -> {
            try {
                while (true) {
                    int projectId = projects.take();
                    processProject(projectId, "TeamLeadOne");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread teamLeadTwo = new Thread(() -> {
            try {
                while (true) {
                    int projectId = projects.take();
                    processProject(projectId, "TeamLeadTwo");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        manager.start();
        teamLeadOne.start();
        teamLeadTwo.start();
    }

    private static void processProject(int projectId, String teamLead) throws InterruptedException {
        System.out.println(teamLead + " is doing the project: " + projectId);
        Thread.sleep(1000);
        System.out.println(teamLead + " has completed project: " + projectId);
    }
}
