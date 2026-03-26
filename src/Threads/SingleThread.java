package Threads;

public class SingleThread {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 1000000000; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
//        System.out.println(Thread.currentThread().getName()); // find the current thread name
        long countOdd = 0;
        for (int i = 0; i < 1000000000; i++) {
            if(i % 2 == 0)
                countOdd++;
        }
        System.out.println(countOdd);
        System.out.println("Time taken by thread: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
