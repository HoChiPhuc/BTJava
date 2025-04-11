package bai3;

public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread producerThread = new Thread(new ProducerRunnable(buffer));
        Thread consumerThread = new Thread(new ConsumerRunnable(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

