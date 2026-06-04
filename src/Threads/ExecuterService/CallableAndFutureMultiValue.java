package Threads.ExecuterService;

import java.util.List;
import java.util.concurrent.*;

public class CallableAndFutureMultiValue {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        // Invoke all will invoke all threads, return results, futures will get the results
        /*
        List<Callable<Integer>> tasks = List.of(
                () -> {
                    Thread.sleep(2000);
                    return 15;
                },
                () -> {
                    Thread.sleep(1000);
                    return 11;
                },
                () -> {
                    Thread.sleep(3000);
                    return 9;
                },
                () -> {
                    Thread.sleep(4000);
                    return 4;
                }
        );

        try {
            List<Future<Integer>> results = service.invokeAll(tasks);
            // Results will come in submission order not win order
            for (Future<Integer> future : results) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        // Collecting Futures in a list:
        List<Future<Integer>> futures = service.invokeAll(tasks);

        List<Integer> results = new ArrayList<>();
        for (Future<Integer> f : futures) {
            results.add(f.get()); // blocks per future until result is ready
        }

        System.out.println(results); // [15, 11, 9, 4]
         */

        // InvokeAny will get the result from any thread, thread that is fastest will win

        List<Callable<Integer>> tasks = List.of(
                () -> {
                    Thread.sleep(2000);
                    return 15;
                },
                () -> {
                    Thread.sleep(1000);
                    return 11;
                },
                () -> {
                    Thread.sleep(3000);
                    return 9;
                },
                () -> {
                    Thread.sleep(4000);
                    return 4;
                }
        );

        try {
            int winner = service.invokeAny(tasks);
            System.out.println("Number : " +  winner + " is the winner......");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
