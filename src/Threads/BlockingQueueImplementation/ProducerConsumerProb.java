package Threads.BlockingQueueImplementation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProb {
    public static void main(String[] args) {
        final int capacity = 8;
        BlockingQueue<String> projects = new ArrayBlockingQueue<>(capacity);

        Thread producer = new Thread(new Producer(projects));
        Thread consumer = new Thread(new Consumer(projects));

        producer.start();
        consumer.start();

    }
}

class Producer implements Runnable {

    private BlockingQueue<String> projects;

    public Producer(BlockingQueue<String> projects) {
        this.projects = projects;
    }

    @Override
    public void run() {
        String[] projectList;
        projectList = new String[]{"Web", "App", "React", "Flutter", "java", "Desktop", "React Native",
                "HTML/Css/JS", "Next Js", "AI Automation", "RAG", "Blog", "Shopify", "SEO",
                "WordPress", "Python", "PHP", "Ruby", "BlockChain"};
        for (String project : projectList) {
            try {
                projects.put(project);
                System.out.println(project + " : is added to the Queue");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<String> projects;

    public Consumer(BlockingQueue<String> projects) {
        this.projects = projects;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String project = projects.take();
                System.out.println(project + " : is taken");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
