package bài6;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiFileReader {
    public static void main(String[] args) {
        String[] files = {"input1.txt", "input2.txt"};
        ExecutorService executor = Executors.newFixedThreadPool(files.length);

        for (String file : files) {
            executor.execute(new FileReadTask(file));
        }
        
        executor.shutdown();
    }
}

class FileReadTask implements Runnable {
    private final String fileName;

    public FileReadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        synchronized (System.out) { // Đảm bảo không bị lẫn dòng khi in ra
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                System.out.println("Nội dung từ " + fileName + ":");
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
