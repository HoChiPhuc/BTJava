package bai1;

public class OddRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Odd: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}
