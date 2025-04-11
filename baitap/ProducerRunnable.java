package bai3;

public class ProducerRunnable implements Runnable {
    private Buffer buffer;

    public ProducerRunnable(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                buffer.produce(i++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

