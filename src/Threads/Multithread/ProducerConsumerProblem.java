package Threads.Multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProducerConsumerProblem {

    public static void main(String[] args) {
        Operator operator = new Operator(0, 6, 1);

        Thread producer = new Thread(() -> {
            try {
                operator.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                operator.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}

class Operator {
    private int sequence;
    private final int max;
    private final int min;
    private final Object Lock;
    private List<Integer> buffer;

    public Operator(int sequence, int max, int min) {
        this.sequence = sequence;
        this.max = max;
        this.min = min;
        Lock = new Object();
        this.buffer = new ArrayList<>();
    }

    public void produce() throws InterruptedException {
        synchronized (Lock) {
            while (true) {
                if (buffer.size() == max) {
                    System.out.println("Container full ... remove some items...");
                    Lock.wait();
                }
                else {
                    System.out.println(sequence + " added to buffer...");
                    buffer.add(sequence++);
                    Lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (Lock) {
            while (true) {
                if (buffer.size() == min) {
                    System.out.println("Container Empty ... Add some items...");
                    Lock.wait();
                }
                else {
                    System.out.println(buffer.removeFirst() + " removed from buffer...");
                    Lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}