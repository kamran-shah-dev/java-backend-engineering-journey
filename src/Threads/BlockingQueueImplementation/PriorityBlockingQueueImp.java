package Threads.BlockingQueueImplementation;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueImp {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<patient> patients = new PriorityBlockingQueue<>();

        patients.put(new patient("Ahmed",   3)); // Stable
        patients.put(new patient("Sara",    1)); // Critical
        patients.put(new patient("Aryan",  2)); // Moderate
        patients.put(new patient("Samandar",    1)); // Critical
        patients.put(new patient("Hassan",  3)); // Stable

        System.out.println("=== Treating patients by severity ===");

        // Doctor thread — always picks most critical first
        while (!patients.isEmpty()) {
            patient p = patients.take();
            System.out.println("Treating: " + p);
            Thread.sleep(500);
        }


    }
}

class patient implements Comparable<patient> {

    private String name;
    private int condition;

    public patient(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }

    @Override
    public int compareTo(patient o) {
        return Integer.compare(this.condition, o.condition);
    }

    @Override
    public String toString() {
        String level = condition == 1? "CRITICAL" : condition == 2? "MODERATE": "NORMAL";
        return this.name + " condition is: " + "[ " + level + " ]";
    }
}