package bai2;

public class Multicast {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MulticastRunnable("n delay", 1));
        Thread thread2 = new Thread(new MulticastRunnable("3 delay", 3));

        thread1.start();
        thread2.start();
    }
}

