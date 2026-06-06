package Threads.Synchronization;

import java.util.concurrent.CountDownLatch;

public class CountDownlatch {
    public static void main(String[] args) throws InterruptedException {
        int teamMembersCount = 3;
        CountDownLatch latch = new CountDownLatch(teamMembersCount);

        new Thread(new TeamMember("Kamran" , "Code Optimization", latch)).start();
        new Thread(new TeamMember("Ahmed" , "Testing", latch)).start();
        new Thread(new TeamMember("Waseem" , "Deployment", latch)).start();

        latch.await();

        System.out.println("Software MVP is ready!");
    }
}

class TeamMember implements Runnable {

    private String name;
    private String taskName;
    private final CountDownLatch latch;

    public TeamMember(String name, String taskName, CountDownLatch latch) {
        this.name = name;
        this.taskName = taskName;
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " is performing the " + taskName);
            Thread.sleep(2000);
            System.out.println(name + " had done the " + taskName);
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
