package Threads.BlockingQueueImplementation;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueImp {

    public static void main(String[] args) {
        DelayQueue<OTP> otps = new DelayQueue<>();
        otps.put(new OTP("ABC123" , 5667898 , 4));
        otps.put(new OTP("DEF123" , 4667780 , 1));
        otps.put(new OTP("GHI123" , 9667096 , 4));
        otps.put(new OTP("JKL123" , 8667673 , 3));
        otps.put(new OTP("MNO123" , 1667109 , 3));
        otps.put(new OTP("PQR123" , 6657898 , 5));
        otps.put(new OTP("STU123" , 7607898 , 2));

        Thread invalidate = new Thread(() -> {
            while (!otps.isEmpty()) {
                try {
                    OTP otp = otps.take();
                    System.out.println("EXPIRED - User: " + otp.userId + ", Code: " + otp.code);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        invalidate.start();
    }
}

class OTP implements Delayed {

    String userId;
    int code;
    long expiresAt;

    public OTP(String userId, int code, long expiresAt) {
        this.userId = userId;
        this.code = code;
        this.expiresAt = System.nanoTime() + TimeUnit.SECONDS.toNanos(expiresAt);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expiresAt - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(expiresAt, ((OTP) o).expiresAt);
    }
}