package Threads.ExecuterService;

import java.util.concurrent.*;

// Two concepts - 1. Callable, 2. Future
// Callable is a generic interface, while Future is a generic class
public class ReturningValueFromThreads {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {



            Future<Integer> result = service.submit(new ReturnValue());

            // if we set a timeout, then Future will wait for that much time and then it will through exception
            // if results were not finalized and returned, if results returned the execution will be smooth.

            System.out.println(result.get(4, TimeUnit.SECONDS));

            // other Future functions
            result.cancel(true); // true - will be cancelled, false - will not be cancelled

            boolean val = result.isCancelled(); // returns true of false based on thread cancellation

            boolean val2 = result.isDone(); // Will return true if execution is completed, false otherwise.

            // if results is not yet returned and get is called, it will block the main thread
            System.out.println("Main thread executed after Future result.");

        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }


    }
}

class ReturnValue implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        // Let's add some waiting time to see will main thread get blocked
        Thread.sleep(3000);
        return 13;
    }
}
