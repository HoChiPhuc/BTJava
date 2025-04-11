package bài7;
import java.io.*;
import java.util.concurrent.*;

class FileReaderTask implements Callable<String> {
    private RandomAccessFile file;
    private long start;
    private long end;

    public FileReaderTask(RandomAccessFile file, long start, long end) {
        this.file = file;
        this.start = start;
        this.end = end;
    }

    @Override
    public String call() throws Exception {
        byte[] buffer = new byte[(int) (end - start)];
        file.seek(start);
        file.readFully(buffer);
        return new String(buffer);
    }
}

public class MultiThreadedFileReader {
    private static final int CHUNK_SIZE = 1024 * 1024; // 1MB

    public static void main(String[] args) throws Exception {
        String filePath = "largefile.txt"; // Đường dẫn file cần đọc
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        long fileSize = file.length();
        int numChunks = (int) Math.ceil((double) fileSize / CHUNK_SIZE);
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<String>[] results = new Future[numChunks];

        for (int i = 0; i < numChunks; i++) {
            long start = i * CHUNK_SIZE;
            long end = Math.min(start + CHUNK_SIZE, fileSize);
            results[i] = executor.submit(new FileReaderTask(new RandomAccessFile(filePath, "r"), start, end));
        }

        StringBuilder finalContent = new StringBuilder();
        for (Future<String> result : results) {
            finalContent.append(result.get());
        }

        executor.shutdown();
        file.close();

        System.out.println("File Content:");
        System.out.println(finalContent.toString());
    }
}

