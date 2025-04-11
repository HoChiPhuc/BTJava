package bai3;
import java.util.LinkedList;

public class Buffer {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int SIZE = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (list.size() == SIZE) {
            wait();
        }
        list.add(value);
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (list.isEmpty()) {
            wait();
        }
        int value = list.removeFirst();
        System.out.println("Consumed: " + value);
        notify();
    }
}
