package Collections.vectors;

import java.util.ArrayList;
import java.util.Vector;

public class SynchronizedVectorUseCase {
    public static void main(String[] args) {
        // we know vectors are thread safe in multi-threaded environment, here is an example to show that.
        /*
        ArrayList<Integer> list = new ArrayList<>();

        // Thread 1
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 2000; i++) {
                list.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 2000; i++) {
                list.add(i);
            }
        });

        t1.start(); t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(list.size()); // Answer will be 2934 because ArrayList is not synchronized, untill explicitly done

         */


        // using vectors
        Vector<Integer> list = new Vector<>();

        // Thread 1
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 2000; i++) {
                list.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 2000; i++) {
                list.add(i);
            }
        });

        t1.start(); t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(list.size()); // Answer will be 4000 because a vector is synchronized

    }
}
