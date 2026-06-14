package Threads.Concurrent;
/*
* Note: When we are reading content from the list, and a writer thread wants to write, a copy of
* List will be created and in that the values will be written and next time if we read it we will be reading
* from that copy so there will be no exception thrown in this case. CopyOnWriteArray is Thread Safe in
* A Multi threaded environment.
* Think about Git Branching, in same manner every write operation will create a new version of the list, array.
* */
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayDemo {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.Simulate();
    }
}

class Simulation {
    private List<Integer> list;

    public Simulation() {
        this.list = new CopyOnWriteArrayList<>();
        this.list.addAll(Arrays.asList(0,1,0,1,0,1,0,1,0,1,0,1));
    }

    public void Simulate() {
        Thread one = new Thread(new Writer(list));
        Thread two = new Thread(new Writer(list));
        Thread three = new Thread(new Writer(list));
        Thread four = new Thread(new Reader(list));
        Thread five = new Thread(new Reader(list));

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
    }

}

class Reader implements Runnable {
    private List<Integer> list;

    public Reader(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        int counter = 10;
        while (counter > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Reading List: " + list);
            counter --;
        }
    }
}

class Writer implements Runnable {
    private List<Integer> list;
    private Random random;

    public Writer(List<Integer> list) {
        this.list = list;
        this.random = new Random();
    }

    @Override
    public void run() {
        int counter = 10;
        while (counter > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.set(random.nextInt(list.size()) , random.nextInt(20));
            counter --;
        }
    }
}

