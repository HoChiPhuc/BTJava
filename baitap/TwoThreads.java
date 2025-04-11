package bai1;

public class TwoThreads {
    public static void main(String[] args) {
        Thread evenThread = new Thread(new EvenRunnable());
        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();
    }
}

