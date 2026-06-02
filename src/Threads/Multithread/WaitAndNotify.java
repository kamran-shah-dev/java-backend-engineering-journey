package Threads.Multithread;

public class WaitAndNotify {
    private static final Object Lock = new Object();

    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            try {
                method1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread two = new Thread(() -> {
            try {
                method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();
    }

    public static void method1() throws InterruptedException {
        synchronized (Lock) {
            System.out.println("I am method one...");
            Lock.wait();
            System.out.println("I am here in method one again...");

        }
    }

    public static void method2() throws InterruptedException {
        synchronized (Lock) {
            System.out.println("I am method two...");
            Lock.notify();
            System.out.println("I am done and notifying others to work...");

        }
    }

}

// Wait and Notify Notes
/*
* Wait & Notify:

1. Wait & Notify (Inter-Thread Communication)
The Purpose: Used for orchestration and communication between threads when working on a shared resource

wait(): Suspends the current thread and places it into a waiting state, releasing its hold on the lock so
* other threads can use it

notify(): Signals and wakes up a waiting thread that the lock has been released

Crucial Detail: notify() is not instantaneous. The notifying thread will finish executing the rest of its
* synchronized code block before the lock is actually released to the waiting thread

notifyAll(): Wakes up all threads currently waiting on that specific lock instead of just picking one

2. Explicit Locks (The Lock Interface)
The Purpose: An alternative to synchronized blocks that offers significantly more flexibility and
* fine-grained safety

Key Benefits over synchronized:

Allows you to manually acquire (lock()) and release (unlock()) locks across different methods, sequences,
* or scopes

Provides non-blocking checks like tryLock(), letting a thread do alternative processing if a lock is
* currently unavailable instead of just freezing

The Finally Block Rule: Because explicit locks do not release automatically, you must always place unlock()
* inside a finally block

3. Conditions (Attached to Locks)
The Purpose: Achieves the exact same concept as wait() and notify(), but provides much more granular
* control over complex synchronization

The Methods: * condition.await() (replaces wait())

condition.signal() (replaces notify())

condition.signalAll() (replaces notifyAll())

Advantage: A single explicit lock can have multiple independent conditions attached to it
* (e.g., a bufferNotFull condition and a bufferNotEmpty condition), allowing you to target and wake up
* specific threads precisely

* */
