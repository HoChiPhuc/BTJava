package bai3;

public class ConsumerRunnable implements Runnable {
    private Buffer buffer;

    public ConsumerRunnable(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                buffer.consume();
                Thread.sleep(1500);
            } catch (InterruptedException e) {}
        }
    }
}

