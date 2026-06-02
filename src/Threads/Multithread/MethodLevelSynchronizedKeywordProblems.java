package Threads.Multithread;

public class MethodLevelSynchronizedKeywordProblems {

    private static int counter1, counter2;
    public static void main(String[] args) {
        Thread incOne = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                incrementCounterOne();
        });

        Thread incTwo = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                incrementCounterTwo();
        });

        incOne.start();
        incTwo.start();

        try {
            incOne.join();
            incTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Result: \n" + "Counter 1 = " + counter1 + " , Counter 2 = " + counter2);

    }

    public static synchronized void incrementCounterOne () {
        counter1++;
    }

    public static synchronized void incrementCounterTwo () {
        counter2++;
    }
}

// Notes: If we notice, thread 1 and thread 2 are working on independent resources, so there will not be any synchronization
// issues, but, we used synchronized keyword with static methods, this way if thread one is working on method 1,
// but it will take the class level lock and even though thread 2 is not working on the first method, it will block thread 2,
// this is because they are the methods of same class and thread 1 has acquired the monitor lock.

// Here are the three main problems with using synchronized keyword.
/*
* 1. How It Works (Monitor Locks & Mutex)
Mutual Exclusion (Mutex): The rule that only one thread can access a shared resource or critical section at
* any single instant.

Monitor Lock: Every Java object has an implicit, built-in lock.

The Flow: A thread must acquire the object's monitor lock to run a synchronized method. While held, other
* threads are blocked; once finished, the lock is released for the next thread.

The 3 Problems with Method-Level Synchronization
Problem 1: Coarse-Grained Locking (Reduced Concurrency)
Locking the entire method body means if you have 100 lines of code but only 3 are critical, threads are
* needlessly blocked from running the other 97 non-critical lines, creating performance bottlenecks.

Problem 2: Loss of Fine-Grained Control (Unnecessary Blocking)
Independent resources share the same object lock. If a class has two different synchronized methods
* manipulating two entirely unrelated variables, a thread calling Method 1 will completely block another
* thread trying to call Method 2.

Problem 3: Subclass Overriding Limitations
Synchronization behavior is not inherited. If a subclass overrides a synchronized method, it must explicitly
* declare it as synchronized as well, or the thread-safety is lost.
* */