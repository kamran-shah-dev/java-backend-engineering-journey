/*
* Note: First thread sends data, but it accepts data as well, until it receives no data it will be
* Blocked, when second thread sends data, now first thread will receive it and send the data. That's the
* Blocking mechanism occurs in exchanger.
* */


package Threads.Concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchange = new Exchanger<>();

        Thread one = new Thread(new FirstThread(exchange));
        Thread two = new Thread(new SecondThread(exchange));

        one.start();
        two.start();

    }

    public static class FirstThread implements Runnable {

        private Exchanger<String> exchanger = new Exchanger<>();

        public FirstThread(Exchanger<String> exchange) {
            this.exchanger = exchange;
        }

        @Override
        public void run() {

            String data = "Shiza";
            System.out.println("Thread one is sending: " + data);

            try {
                String recieved = exchanger.exchange(data);
                System.out.println("Thread one recieved " + recieved);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class SecondThread implements Runnable {

        private Exchanger<String> exchanger = new Exchanger<>();

        public SecondThread(Exchanger<String> exchange) {
            this.exchanger = exchange;
        }

        @Override
        public void run() {


            try {
                Thread.sleep(3000);
                String data = "Fizza";
                System.out.println("Thread Two is sending: " + data);
                String recieved = exchanger.exchange(data);
                System.out.println("Thread Two recieved " + recieved);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
