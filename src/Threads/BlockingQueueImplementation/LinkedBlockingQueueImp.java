package Threads.BlockingQueueImplementation;
import java.util.concurrent.*;

public class LinkedBlockingQueueImp {

    // Unbounded — handles log bursts without blocking the web server
    private static final BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        // Producer: Web server generating logs
        Thread webServer = new Thread(() -> {
            String[] logs = {"ERROR: NullPointer", "INFO: Request OK", "WARN: Slow response",
                    "ERROR: DB timeout",  "INFO: User login",  "INFO: Cache hit"};
            for (String log : logs) {
                try {
                    logQueue.put(log);
                    System.out.println("[SERVER]   queued  -> " + log);
                    Thread.sleep(300);
                } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        });

        // Consumer 1: Writes to file
        Thread fileWriter = new Thread(() -> {
            while (true) {
                try {
                    String log = logQueue.take();
                    System.out.println("[FILE]     writing -> " + log);
                } catch (InterruptedException e) { break; }
            }
        });

        // Consumer 2: Alerts on errors
        Thread alerter = new Thread(() -> {
            while (true) {
                try {
                    String log = logQueue.peek(); // look without removing
                    if (log != null && log.startsWith("ERROR")) {
                        System.out.println("[ALERT]    sending -> " + logQueue.take());
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) { break; }
            }
        });

        webServer.start();
        fileWriter.start();
        alerter.start();
    }
}