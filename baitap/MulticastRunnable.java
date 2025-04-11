package bai2;

public class MulticastRunnable implements Runnable {
    private String name;
    private int delay;

    public MulticastRunnable(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " message " + i);
            try { Thread.sleep(delay * 1000); } catch (InterruptedException e) {}
        }
    }
}

